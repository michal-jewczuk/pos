pipeline {

    agent any

    stages {
        stage('Clean & Compile') {
            steps {
                echo 'Cleaning and compiling'
                sh "./gradlew clean bootJar -PjarType=${getJarType()}"
            }

            post {
                always {
                    archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
                }
            }
        }

        stage('Tests') {
            steps {
                echo 'Running unit tests'
                sh './gradlew check jacocoTestReport'

                step([$class: 'JacocoPublisher'])
            }

            post {
                always {
                    junit '**/build/test-results/test/TEST-*.xml'
                }
            }
        }

        stage('Deploy to dev') {
            parallel {
                stage('develop') {
                    when {
                        expression { return getBranchType() == "develop";}
                    }
                    steps {
                        echo "Deploying to dev on ${getBranchName()}"
                        sh './deploy_to_dev.sh'
                    }
                }
                stage('feature') {
                    when {
                        beforeInput true
                        expression { return getBranchType() == "feature";}
                    }
                    input {
                        message "May I proceed and deploy to dev this feature build?"
                        ok "Yes, you may!"
                    }
                    steps {
                        echo "Deploying to dev on ${getBranchName()}"
                        sh './deploy_to_dev.sh'
                    }
                }
            }

        }

        stage('Deploy to production') {
            when {
                expression {
                    return getBranchType() == "release"
                }
            }
            steps {
                echo "Deploying to production on ${getBranchName()}"
                sh './deploy_to_prod.sh'
            }
        }

    }

}

def getBranchName() {
    env.BRANCH_NAME
}

def getBranchType() {
    def branchName = getBranchName()

    if (branchName.startsWith("feature")) {
        return "feature"
    } else if (branchName.startsWith("release")) {
        return "release"
    } else if (branchName.startsWith("develop")) {
        return "develop"
    } else {
        return "unrecognized"
    }
}

def getJarType() {
    def branchType = getBranchType()

    if (branchType == 'release') {
        return 'RELEASE'
    }

    return 'SNAPSHOT'
}
