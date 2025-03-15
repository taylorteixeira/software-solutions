### **VIA DOCKER TERMINAL/BASH**

```
docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=satc@2023" -p 1433:1433 --name satc-sql-server --hostname satc-sql-server -d mcr.microsoft.com/mssql/server:2022-latest
```

### **VIA DOCKER COMPOSE**

![[docker-compose.yml]]

Conteúdo do arquivo docker-compose.yaml

```
services:
  mssqlserver:
    image: mcr.microsoft.com/mssql/server:2022-latest
    container_name: satc-sql-server
    hostname: satc-sql-server
    restart: always
    environment:
      ACCEPT_EULA: "Y"
      MSSQL_SA_PASSWORD: "satc@2025"
      MSSQL_PID: "Developer"
    ports:
      - 1435:1433
    volumes:
      - mssql_data:/var/opt/mssql
  
volumes:
  mssql_data:
networks:
  proxy:
    name: proxy
    external: true
```

Para iniciar o container a partir do arquivo acima, digitar:

```
docker-compose up -d
```

O -d apaga o container assim ele for encerrado, a imagem baixada permanece no disco)

Para encerrar o container a partir do arquivo acima, digitar:

```
docker-compose down
```
