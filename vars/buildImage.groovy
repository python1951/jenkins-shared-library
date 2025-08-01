#!/usr/bin/env groovy

def call(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'github-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t \n' +
                'qamarha28812/demo-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push \n' +
                'qamarha28812//demo-app:jma-2.0'
    }
}