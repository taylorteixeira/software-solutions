
Abrir o link a seguir [https://docs.docker.com/engine/install/ubuntu/](https://docs.docker.com/engine/install/ubuntu/) e executar os passos abaixo:

## Instrução passo a passo
### [OS requirements](https://docs.docker.com/engine/install/ubuntu/#os-requirements) (Requisitos de S.O.)

To install Docker Engine, you need the 64-bit version of one of these Ubuntu versions:

- Ubuntu Oracular 24.10
- Ubuntu Noble 24.04 (LTS)   <= Versão utilizada nos labs da disciplina de Engenharia de dados
- Ubuntu Jammy 22.04 (LTS)
- Ubuntu Focal 20.04 (LTS)
### [Uninstall old versions](https://docs.docker.com/engine/install/ubuntu/#uninstall-old-versions) (Desinstalando versões antigas ou pré-existentes)

```
for pkg in docker.io docker-doc docker-compose docker-compose-v2 podman-docker containerd runc; do sudo apt-get remove $pkg; done
```

### [Install using the `apt` repository](https://docs.docker.com/engine/install/ubuntu/#install-using-the-repository) (Instalacao do Docker)

1. Set up Docker's `apt` repository. (Setup do repositório para download dos binários do Docker Engine)

```
# Add Docker's official GPG key:
sudo apt-get update
sudo apt-get install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc

# Add the repository to Apt sources:
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "${UBUNTU_CODENAME:-$VERSION_CODENAME}") stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update
```

2. Install the Docker packages (instalação do Docker Engine).

```
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

# Validar funcionamento do Docker Engine no Ubuntu

Executar o comando abaixo e ver o resultado.

```
docker images
```

Caso apareça a tela abaixo, parabéns, está tudo ok com sua instalação.

![[Pasted image 20250306113504.png]]

Caso apareça a mensagem abaixo, você precisará ajustar a permissão do usuário `ed` para execução dos comandos `docker`.

```
ed@edsatc:~$ docker images
permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Head "http://%2Fvar%2Frun%2Fdocker.sock/_ping": dial unix /var/run/docker.sock: connect: permission denied
```

Para isso, execute os comandos abaixo na sequência.

### 1. Executar o comando com `sudo`

Tente rodar o comando com `sudo` para verificar se é um problema de permissão:

```
sudo docker images
```

Se funcionar, siga o restante do procedimento. Caso não funcione, refaça a instalação do **docker engine** através do procedimento anterior.

### 2. Adicionar seu usuário ao grupo `docker`

1. Adicione seu usuário ao grupo `docker`:

```
sudo usermod -aG docker $USER
```

2. . Atualize a sessão do usuário para aplicar as mudanças (ou reinicie o sistema):

```
newgrp docker
```

Nota: Caso ele peça alguma senha, reinicie a máquina virtual.

3. Agora tente rodar o comando sem `sudo`:

```
docker images
```

A partir de agora você tem o DOCKER instalado no seu linux Ubuntu para gerenciar suas imagens e containers.