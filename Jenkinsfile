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
                    stash includes: '**/build/libs/*.jar', name: 'archived'
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
            when {
                expression {
                    return getBranchType() == "develop";
                }
            }
            steps {
                unstash 'archived'
                sh 'ls | grep ".jar"'
                echo "Deploying to dev on ${getBranchName()}"
                sh './gradlew deployToDev'
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
