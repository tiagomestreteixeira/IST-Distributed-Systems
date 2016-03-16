# Web Services Implementation-First

## Objetivos

*   Desenvolver Web Services em Java usando a abordagem _implementation-first_
*   Publicar e pesquisar Web Services no servidor de nomes jUDDI

# Web Services

Um serviço é uma funcionalidade de um sistema de informação que pode ser invocada remotamente através da rede.  
Um _Web Service_ é um serviço que usa os protocolos de comunicação da _World Wide Web_ - HTTP sobre TCP sobre IP - e protocolos adicionais para descrever mensagens e dados - SOAP sobre XML.

Para permitir uma definição rigorosa das operações e dos tipos de dados dos _Web Services_ são usadas as linguagens WSDL (_Web Services Description Language_) e XSD (_XML Schema Definition_), respetivamente.

Para a publicação e pesquisa de _Web Services_ usa-se um servidor de nomes que implementa a norma UDDI (_Universal Description, Discovery and Integration_). No Sun RPC usa-se o <code>rpcbind</code>, no Java RMI usa-se o <code>rmiregistry</code>, nos Web Services usa-se o <code>jUDDI</code> (_Java UDDI_).

Para uma explicação mais detalhada destas tecnologias, ver:

*   Livro de Couloris, Capítulo 9
*   [UDDI](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/05-ws1/uddi/index.html)

## JAX

As bibliotecas JAX (_Java API for XML_) são a família de bibliotecas da plataforma Java que lidam com tecnologias baseadas em XML, como é o caso dos _Web Services_.

A JAX-WS (Java API for XML Web Services) é uma biblioteca para Java que permite implementar _Web Services_, usando as normas: HTTP/TCP/IP para mensagens, SOAP/XML para mensagens, WSDL e XSD para descrição.

Para comunicar com servidores UDDI, existe a biblioteca JAX-R (Java API for XML Registries), que permite publicar, pesquisar e eliminar registos de _Web Services_.

Para uma explicação mais detalhada destas tecnologias, ver:

*   [JAX-WS](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/05-ws1/jaxws/index.html)
*   [JAX-R](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/05-ws1/jaxr/index.html)

O esquema de dados do UDDI é consideravelmente mais rico do que o habitual num servidor de nomes, com diversas entidades e relações, que permitem guardar informação de negócio sobre a organização e os seus serviços. Como consequência, o JAX-R é uma biblioteca verbosa, que obriga a escrever muitas linhas de código para realizar as tarefas mais habituais de registo e de pesquisa.

Para tornar a utilização do UDDI mais simples foi criada a biblioteca <code>UDDINaming</code> que simplifica o esquema de dados para suportar apenas:  
1 organização, 1 serviço e 1 implementação.  
Esta biblioteca, cujo código está disponível para consulta e modificação, torna o registo e pesquisa de serviços mais sucinto.

* * *

# Exemplo

Vamos então ver um exemplo de um _Web Service_ feito em Java, que usa a biblioteca <code>UDDINaming</code> para comunicar com o servidor de nomes.

1.  **jUDDI**

*   O servidor de nomes a utilizar é o jUDDI (_Java UDDI_), que faz parte do [software](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/software/index.html) que se pediu para instalar.
*   Para lançar o servidor, basta executar o seguinte comando na pasta <code>juddi-.../bin</code>:

*   <code>startup.sh</code> (Linux e Mac)
*   <code>startup.bat</code> (Windows)

*   Para confirmar funcionamento, aceder à página de índice do jUDDI, que dá também acesso à interface de administração  
    [http://localhost:9090/juddiv3/](http://localhost:9090/juddiv3/)

*   utilizador:senha <code>uddiadmin:da_password1</code>

3.  **UDDINaming**

*   Obter o código da biblioteca <code>UDDINaming</code>:

*   [Biblioteca uddi-naming ![ZIP](../_img/zip.png)](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/05-ws1/uddi-naming.zip)

*   Instalar o módulo no repositório Maven local:
    *   <code>cd uddi-naming</code>
    *   <code>mvn install</code>
*   A biblioteca inclui um teste de integração (IT - _Integration Test_)  
    que verifica o funcionamento correto do jUDDI antes de instalar o módulo.
*   Uma vez instalado o módulo no repositório Maven local, a biblioteca pode ser usada como dependência num <code>pom.xml</code>:

    <code>
        <!-- UDDI Naming -->
        <dependency>
            <groupId>pt.ulisboa.tecnico.sdis</groupId>
            <artifactId>uddi-naming</artifactId>
            <version>1.0</version>
        </dependency>
        ...
    </code>

5.  **Servidor JAX-WS**

É possível implementar Web Services partindo de código Java já existente. Esta abordagem de desenvolvimento designa-se por _implementation-first_. Para transformar um tipo Java num _Web Service_, basta usar a anotação <code>@WebService</code>. As descrições em WSDL e XSD são geradas automaticamente quando o servidor se executa.

*   Obter o código do servidor:

*   [Hello World Web Service (Implementation-First) ![ZIP](../_img/zip.png)](hello-ws_juddi.zip)

*   Construir o servidor:

*   <code>cd hello-ws_juddi</code>
*   <code>mvn compile</code>

*   Executar o servidor:

*   <code>mvn exec:java</code>  
    O nome da classe a executar e os argumentos estão definidos no <code>pom.xml</code>  
    O servidor deve executar sem erros, disponibilizando o _endpoint address_ e registando-se no UDDI.
*   Confirmar que o servidor está à espera de pedidos e consultar o contrato que é gerado automaticamente:
    *   [http://localhost:8080/hello-ws/endpoint?wsdl](http://localhost:8080/hello-ws/endpoint?wsdl)

    *   [http://localhost:8080/hello-ws/endpoint?xsd=1](http://localhost:8080/hello-ws/endpoint?xsd=1)

8.  **Cliente JAX-WS**

*   Obter o código do cliente:

*   [Web Service client ![ZIP](../_img/zip.png)](hello-ws-cli_juddi.zip)

*   Construir o cliente:

*   <code>cd hello-ws-cli_juddi</code>
*   <code>mvn compile</code>  
    Executa previamente <code>generate-sources</code> onde o cliente obtém o contrato WSDL a partir do servidor e  
    usa a ferramenta <code>wsimport</code> para gerar as classes de invocação do serviço (em <code>target/</code>)  

*   Executar o cliente:

*   <code>mvn exec:java</code>  
    O cliente deve executar sem erros, consultando o UDDI para descobrir o endereço do servidor,  
    e fazendo uma invocação remota.

## Resumo

Primeiro foi lançado o servidor de nomes jUDDI.  
Depois foi instalada a biblioteca UDDINaming no repositório Maven local, que testa também o funcionamento do servidor jUDDI.  
Em seguida, foi construído e iniciado o servidor, que se regista no jUDDI e fica à espera de pedidos no _endpoint address_.  
Finalmente, o cliente obtém o WSDL a partir do servidor e gera o código de invocação que permite depois fazer invocações remotas.

Depois de testado o Exemplo, passar ao Exercício.

* * *

# Exercício

Partindo do exemplo acima, foi construído um novo Web Service Tic Tac Toe (jogo do galo).  
![Tic Tac Toe](ttt.png)

*   O ponto de partida foi o programa [ttt-local](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/05-ws1/ttt-local.zip)
*   O ponto de chegada consiste em dois programas: **servidor** [ttt-ws_juddi](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/05-ws1/ttt-ws_juddi.zip) e **cliente** [ttt-ws-cli_juddi](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/05-ws1/ttt-ws-cli_juddi.zip).

*   A estrutura dos projetos está montada mas, **atenção**,  
    **faltam ainda alterações importantes assinaladas com "..."**,  
    quer no <code>pom.xml</code>, quer no código Java!

*   O **objetivo** do exercício é acrescentar o que falta e colocar o servidor e cliente a funcionar.

1.  No **servidor** (<code>ttt-ws_juddi</code>):

*   Configurar no ficheiro <code>pom.xml</code>:

*   A dependência para a biblioteca UDDINaming (em falta dentro da tag <code><dependencies></code>).
*   A localização do UDDI (<code>uddi.url</code>)  
    Por omissão, o valor é <code>http://localhost:9090</code>.
*   O nome do serviço a registar (<code>ws.name</code>)
*   O endereço do serviço a disponibilizar (<tt>ws.url</code>)  
    Por exemplo, <code>http://localhost:8080/ttt-ws/endpoint</code>

*   Consultar a interface <code>TTT</code> e respectiva implementação <code>TTTImpl</code>
*   Completar as anotações <code>javax.jws.WebService</code>, indicando a interface implementada: <code>ttt.TTT</code>

<code>
    @WebService(endpointInterface="...")
    public class TTTImpl implements TTT {

</code>

*   Depois de efectuadas as alterações:  
    <code>mvn compile exec:java</code>  
    (a classe a executar e os argumentos estão definidos no <code>pom.xml</code>)  

*   Consultar o WSDL gerado dinamicamente, que deverá estar disponível no endereço  
    [http://localhost:8080/ttt-ws/endpoint?WSDL](http://localhost:8080/ttt-ws/endpoint?WSDL).

5.  No **cliente** (<code>ttt-ws-cli_juddi</code>):

*   Configurar no ficheiro <code>pom.xml</code>:

*   A dependência para a biblioteca UDDINaming (em falta dentro da tag <code><dependencies></code>).
*   A localização do UDDI (<code>uddi.url</code>)  

*   O nome do serviço a pesquisar (<code>ws.name</code>)

*   Gerar o código necessário às invocações remotas a partir do WSDL:  
    <code>mvn generate-sources</code>  
    O WSDL é necessário para a compilação do cliente, pelo que o servidor deverá estar a correr.  
    Caso se pretenda gerar novamente as classes, deve fazer-se:  
    <code>mvn clean generate-sources</code>  

*   Consultar <code>./target/generated-sources/wsimport</code> ou faça _refresh_ no _package explorer_ do Eclipse.  

*   Verificar que alterações ocorreram nas pastas do projeto em resultado da geração de código a partir do WSDL.  
    Inspeccione o conteúdo dos novos ficheiros gerados e tente compreender a função de cada um.
*   Abrir e analisar o ficheiro cujo nome termina em <code>...Service.java</code>.  
    A classe <code>...Service</code> estende a classe <code>javax.xml.ws.Service</code>, que é a classe que o JAX-WS fornece para acesso ao serviço remoto.  
    A classe gerada já está configurada para o _Web Service_ em causa, logo é mais fácil de usar que usando a classe Service diretamente.

*   No método <code>main()</code> do cliente, criar uma instância de <code>...Service</code> e chamar o método <code>get...Port()</code>, que retorna uma instância da interface (remota) do seu Web Service. A partir daí, pode invocar qualquer operação chamando métodos dessa interface.

<code>
    public Game() {
        ...

        ...Service service = new ...Service();
        ... port = service.get...Port();

</code>

*   Agora já deverá ser possível compilar a aplicação sem erros:  
    <code>mvn compile</code>
*   E jogar:  
    <code>mvn exec:java</code>

## Perguntas

1.  Estude o WSDL gerado. Consegue mapear o código Java para as definições WSDL e XSD?
2.  Onde, no WSDL, é especificado o tipo de argumentos do Web Service?
3.  Compare o WSDL gerado com o ficheiro <code>ttt.x</code> do servidor SUN RPC do ttt.

1.  Que informação é comum a ambos os ficheiros?
2.  Que informação existe no WSDL mas não existe no .x?

5.  Identifique a função de cada ficheiro gerado no cliente (ignore os ficheiros <code>ObjectFactory.java</code> e <code>package-info.java</code> na sua resposta).

O resto do enunciado será entregue na aula.  
O objetivo será estender ou modificar as funcionalidades disponíveis.



## Entrega da solução

Fénix, Avaliação, Projetos, **mini Exercício 3 - Web Services**

A solução completa deverá ser submetida no Fénix **antes do fim da sua aula de laboratório**.  
Emails recebidos depois do fim da aula não serão considerados.  

**Ter atenção ao seguinte:**

*   Só serão aceites trabalhos de alunos que estiveram presentes no laboratório.
*   Assegure-se que a solução é enviada em formato ZIP e que não contém código compilado.  
    (faça <code>mvn clean</code> antes de zipar)
*   Deverá incluir um ficheiro <code>respostas.txt</code> com as respostas às perguntas do enunciado do exercício.
*   Deverá também incluir um ficheiro <code>instrucoes.txt</code> com resumo da funcionalidade implementada e com instruções para colocar o programa a funcionar como esperado.  
    Por exemplo:

*   A funcionalidade pedida foi total/parcialmente implementada **...**
*   O servidor deve compilar e executar com os comandos:  
    <code>mvn compile exec:java</code>
*   O cliente deve compilar e executar com os comandos:  
    <code>mvn generate-sources compile exec:java</code>

* * *


© Docentes de Sistemas Distribuídos, [Dep. Eng. Informática](http://www.dei.tecnico.ulisboa.pt/), [Técnico Lisboa](http://www.ist.eu)  
Última actualização em 22 de fevereiro de 2016 por Miguel Pardal
