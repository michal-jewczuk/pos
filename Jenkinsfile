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

	step([$class: 'JacocoPublisher',
            execPattern: 'build/*.exec',
            classPattern: 'build/classes',
            sourcePattern: 'src/main/java',
            exclusionPattern: 'src/test*'
        ])
      }

      post {
        always {
          junit '**/build/test-results/test/TEST-*.xml'
        }
      }
    }

  }

}
