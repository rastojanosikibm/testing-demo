terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.16"
    }
  }

  required_version = ">= 1.2.0"
}

provider "aws" {
  region  = "eu-central-1"
  shared_credentials_files = ["~/.aws/credentials"]
  profile = "terraform"
}

resource "aws_instance" "jenkins-master" {
  ami           = "ami-023adaba598e661ac"
  instance_type = "t2.micro"
  key_name = "mykeys"
  private_ip = "172.31.20.10"
  tags = {
    Name = "jenkins-master"
  }
}

resource "aws_instance" "selenium-hub" {
  ami           = "ami-023adaba598e661ac"
  instance_type = "t2.micro"
  key_name = "mykeys"
  private_ip = "172.31.20.20"
  tags = {
    Name = "selenium-hub"
  }
}

resource "aws_instance" "selenium-node-1" {
  ami           = "ami-023adaba598e661ac"
  instance_type = "t2.micro"
  key_name = "mykeys"
  private_ip = "172.31.20.30"

  tags = {
    Name = "selenium-node-1"
  }
}

resource "aws_instance" "selenium-node-2" {
  ami           = "ami-023adaba598e661ac"
  instance_type = "t2.micro"
  key_name = "mykeys"
  private_ip = "172.31.20.40"

  tags = {
    Name = "selenium-node-2"
  }
}

resource "aws_key_pair" "jenkins-master" {
  key_name = "mykeys"
  public_key = file("~/.ssh/id_rsa_demo_aws.pub")
}