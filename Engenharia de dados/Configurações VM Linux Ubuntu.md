## **Configuração memória, processador e placa de rede**

Clicar em Configurações, menu Sistema e ajustar a memória base da placa mãe para próximo ao limite verde mostrado na tela abaixo:

![[Pasted image 20250306111246.png]]

#### EXEMPLO:
- Se você tem 16GB de memória RAM, ajustar a Memória Base para algo em torno de 8GB.**
- Se voce tem 32GB de RAM, ajustar a Memória Base para algo em torno de 16GB.

Para a quantidade de processadores, ajustar o valor para 1 CPU abaixo do limite máximo disponível (verde).

![[Pasted image 20250306111040.png]]

No menu Monitor, colocar **110MB** de memória de vídeo e marcar **Habilitar Aceleração 3D**.

No Menu display, ajustar a **Memória de Vídeo** para próximo de **100MB**.

![[Pasted image 20250306111501.png]]

No menu Rede, selecionar a placa de rede conectado a **NAT**.
Importante validar se o botão de **Redirecionamento de Portas** está disponível. Ele será utilizado para permitir o acesso a partir do computador hospedeiro da Virtual Box para dentro da Máquina Virtual.

![[Pasted image 20250306111546.png]]


## **Correção janelas pop up ilegíveis** (somente se isso estiver ocorrendo)

Iniciar o Ubuntu, abrir o terminal e executar os comandos abaixo:

```
sudo vi /etc/gdm3/custom.conf
```

Ao digitar o comando acima, ele vai pedir a senha do usuário (no exemplo abaixo está como usuário **ubuntu**, mas podemos ter usuário **ed** também).


![[Pasted image 20250206220033.png]]

REMOVER o comentário (#) da linha **WaylandEnable=false**.

![[Pasted image 20250206220118.png]]

Para salvar e sair pressione **ESC**, depois digite **:wq** e pressione **ENTER**.

![[Pasted image 20250206220131.png]]

Reinicie a máquina virtual.

## **Configurar idioma do teclado no ubuntu**

Clicar em **Show Applications**, depois digite **Keyboard** no campo de busca e selecione o item **Keyboard** conforme a imagem abaixo.

![[Pasted image 20250206220209.png]]

Clique no botão + na tela abaixo e selecione **Portuguese (Brazil)**, conforme imagem abaixo.

![[Pasted image 20250206220221.png]]

Para quem quiser deixar o layout do teclado português e inglês, você pode alternar entre eles pelo menu abaixo.

![[Pasted image 20250206220259.png]]



