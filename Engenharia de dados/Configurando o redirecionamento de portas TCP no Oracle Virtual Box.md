Clicar em **Configurações** da máquina Virtual selecionada no Virtual Box.

![[Pasted image 20250306161423.png]]

Clicar no menu **Redes** e depois em **Redirecionamento de Portas**.

![[Pasted image 20250306161503.png]]

Com a janela de **Regras de Redirecionamento de Portas** aberta, criar uma linha para cada redirecionamento de portas necessário.

![[Pasted image 20250306161628.png]]

#### Exemplo:
- Para o MSSQL é necessário redirecionar a porta 1433 do windows para a máquina virtual no Virtual Box, conforme a regra mostrada acima.
- Se for usar MySQL, por exemplo, será necessário adicionar mais uma regra (botão de + no canto superior direito da janela acima) e informar 3306 na **Porta do Hospedeiro** e **Porta do Convidado**.