## Install Terraform - Ubuntu
```angular2html
wget -O- https://apt.releases.hashicorp.com/gpg | sudo gpg --dearmor -o /usr/share/keyrings/hashicorp-archive-keyring.gpg

echo "deb [signed-by=/usr/share/keyrings/hashicorp-archive-keyring.gpg] https://apt.releases.hashicorp.com $(lsb_release -cs) main" | sudo tee /etc/apt/sources.list.d/hashicorp.list

sudo apt update && sudo apt install terraform
```

## Verify Terraform is installed
```angular2html
terraform -help
```
## Basic commands
Initialize the project
```angular2html
terraform init
```
Show plan - what to create, update or delete
```
terraform plan
```
Run terraform to create,update or delete resources
```
terraform apply
```
Destroy resources
```
terraform destroy
```