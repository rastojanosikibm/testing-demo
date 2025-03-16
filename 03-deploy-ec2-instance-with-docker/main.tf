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
  profile = "default"
}

resource "aws_instance" "server1" {
  ami           = "ami-023adaba598e661ac"
  instance_type = "t2.large"
  key_name = "mykeys"
  private_ip = "172.31.20.10"
  tags = {
    Name = "server1"
  }
}

resource "aws_key_pair" "server1" {
  key_name = "mykeys"
  public_key = file("~/.ssh/id_ed25519.pub")
}