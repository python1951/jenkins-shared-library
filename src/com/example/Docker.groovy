#!/bin/env groovy
package  com.example

class Docker implements Serializable{
    def script
    Docker(script){
        this.script=script


    }
    def buildDockerImage(String imagename){
        script.echo "building the docker image..."
            script.sh "docker build -t $imagename ."



    }
    def dockerlogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'github', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"

        }
    }
    def dockerpush(String imagename){
        script.sh "docker push $imagename"}

}