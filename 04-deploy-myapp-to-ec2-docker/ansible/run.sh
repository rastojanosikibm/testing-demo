cp
docker run --rm \
--name ansible \
-v ./ansible:/ansible \
-v ~/.ssh:/home/.ssh \
ansible ansible-playbook -i /ansible/hosts.yaml  /ansible/playbooks/install.yml