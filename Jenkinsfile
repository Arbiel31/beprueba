pipeline {

  environment {
    dockerimagename = "arbiel/beprueba"
    dockerImage = ""
  }

  agent any

  stages {

    stage('Checkout Source') {
      steps {
        git 'https://github.com/Arbiel31/beprueba.git'
      }
    }

    stage('Build image') {
      steps{
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }

    stage('Pushing Image') {
      environment {
               registryCredential = 'dockerhub'
           }
      steps{
        script {
          docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
            dockerImage.push("latest")
          }
        }
      }
    }

    stage('Deploying React.js container to Kubernetes') {
      steps {
        script {
          bat "kubectl delete -n default deployment beprueba"
          bat "kubectl create deployment beprueba --image=arbiel/beprueba:latest"
          bat "kubectl delete -n default service beprueba"
          bat "kubectl expose deployment beprueba --type=LoadBalancer --port=8081"
        }
      }
    }

  }

}