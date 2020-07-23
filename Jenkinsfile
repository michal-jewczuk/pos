pipeline {

    agent any

    stages {
        stage('Clean & Compile') {
            steps {
                echo 'Cleaning and compiling'
                sh './gradlew clean classes'
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
            steps {
                echo "Deploying to dev on ${getBranchName}"
                sh './gradlew deployToDev'
            }
        }

    }

}

def getBranchName() {
    env.BRANCH_NAME
}
