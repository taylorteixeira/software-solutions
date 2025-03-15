1. Download Oracle Virtualbox: [https://www.virtualbox.org/](https://www.virtualbox.org/)
2. Criação da Máquina Virtual no Oracle Virtualbox [https://www.youtube.com/watch?v=wTEizwJ6yhY](https://www.youtube.com/watch?v=wTEizwJ6yhY)
	1. Atentar para segmentação dos discos swap, /boot, /home e /
3. instalação do Linux Ubuntu 24.04 LTS: [https://www.youtube.com/watch?v=wTEizwJ6yhY](https://www.youtube.com/watch?v=wTEizwJ6yhY)
4. Efetuar a instalação no modo assistido (cuidar com o nome do servidor, não pode conter espaços em branco).
5. Necessário instalar "Adicionar para convidados"
	1. Inserir o CD pelo menu dispositivos.
	2. instalar o bzip2 (`sudo apt install bzip2`) - Somente se ocorrer um erro de falta desse aplicativo.
	3. `sudo su` (logar com a senha colocada no inicio da instalação desassistida)
	4. `./VBoxLinuxAdditions.sh`
