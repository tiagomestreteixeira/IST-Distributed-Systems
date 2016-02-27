# Ferramentas

## Objectivos da semana

*   Usar o Maven para compilar projectos Java
*   Usar o Eclipse para programar e depurar projectos Java
*   Usar _sockets_ para transferir dados entre cliente e servidor

## Java

O Java Developer Kit (JDK) é um conjunto de ferramentas para programação na linguagem Java.  
As mais importantes são o `javac` que compila os programas e o `java` que lança as aplicações.

`javac` e `java` são suficientes para construir pequenos programas, mas para programas de maior dimensão, é muito útil ter:

*   Uma ferramenta que dê suporte a todas as tarefas de forma integrada, incluíndo a gestão de dependências - **Maven**;
*   Um ambiente que apoie o programador em todas as tarefas - **Eclipse**;
*   Bibliotecas para sistematizar os testes - **JUnit** - e para simular objectos durante os testes - **JMockit**.

A tabela seguinte resume as utilizações mais comuns do JDK, Maven, e Eclipse:

*   [Java tools reference card](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/java-tools-ref-card.pdf) ![PDF](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/pdf.png)

## Maven

A ferramenta Maven é, talvez, a mais importante logo a seguir ao próprio JDK (sim, é mais importante que o Eclipse). A utilização do Eclipse é opcional, mas o Maven é considerado obrigatório.

O Maven desempenha o papel muito importante de explicitar dependências de outros programas e de automatizar toda a construção. Todos os programas devem ter a configuração Maven - **pom.xml** - para que possam ser (re)construídos de forma repetível.

*   [Introdução ao Maven](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/maven/index.html)

*   [Exemplo de aplicação Java simples ![ZIP]http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/zip.png](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/java-app.zip) - utiliza o Maven para compilar e executar

*   Estudar o código fonte e o ficheiro `pom.xml`.
*   Compilar e executar o programa, seguindo as instruções no ficheiro `readme.txt`.  
    Experimente através da linha de comando `mvn ...`

## Eclipse

O Eclipse pode ser configurado por cima do JDK (Eclipse/JDK), ou então por cima também do Maven (Eclipse/Maven/JDK).

*   [Maven no Eclipse](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/eclipse/maven/index.html)
*   [Dicas de utilização do Eclipse](http://www.slideshare.net/MiguelLPardal/eclipse-workshop-presentation)

*   Voltar ao [exemplo de aplicação Java simples](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/java-app.zip):

*   Configurar o projecto no Eclipse, seguindo as indicações no ficheiro `readme.txt`.
*   Experimente executar através da linha de comando `mvn ...` e executar através do Eclipse (opção "run").  

*   Experimente também executar através do Maven dentro do Eclipse (m2eclipse): "Run As", "Maven Build"

*   Experimente as funcionalidades de depuração:

*   Criar um _breakpoint_ no programa e fazer _debug_.
*   Alterar os argumentos do programa e inspeccionar as variáveis durante a execução.

## Sockets

Um _socket_ é uma extremidade de uma ligação através de uma rede de computadores. Atualmente, a comunicação entre computadores faz-se quase sempre com IP (Internet Protocol). Os _sockets_ mais comuns usam TCP (Transmission Control Protocol), que estabelecem uma ligação entre cliente e servidor. Um endereço de _socket_ é composto por um endereço IP e por um número de porto.

![](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/connection-27383_960_720.png)

O Java disponibiliza uma biblioteca de _sockets_ que está disponível no pacote `java.net`. O exemplo seguinte - servidor e cliente - ilustra a comunicação entre dois programas usando esta biblioteca.

*   [Servidor de Sockets TCP/IP ![ZIP](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/zip.png)](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/socket-server.zip) - transferência de texto com sockets TCP/IP
*   [Cliente de Sockets TCP/IP ![ZIP](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/zip.png)](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/socket-client.zip)

Os _sockets_ estão na base da programação da comunicação na World Wide Web. O porto 80 é reservado para comunicação com o HTTP (HyperText Transfer Protocol).

*   [(Breve) introdução à World Wide Web](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/www/index.html)
*   Consultar Seção 1.6 do livro da cadeira e a apresentação das teóricas sobre World Wide Web e Sockets

### Exercício a resolver até ao fim da aula

1.  Obter o exemplo de **sockets TCP/IP**.  
    Neste caso temos dois programas que colaboram entre si.

1.  Configurar os projectos no Eclipse
2.  Estudar o código fonte e os ficheiros `pom.xml` do servidor e do cliente.
3.  Compilar e executar o servidor e cliente, seguindo as instruções no ficheiro `readme.txt`

**[Problemas?](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/exceptions/index.html)**

1.  Analisar o _output_ do Maven, em especial as linhas começadas por <small>[WARNING]</small>:

1.  Qual foi a causa da exceção?
2.  Que exceção é que foi lançada?
3.  Em que linha do código do cliente é que foi lançada a exceção?

*   Ou será um problema na configuração dos argumentos?

1.  Compilar e executar o servidor até funcionar sem erros.

*   Em casos mais complicados, pode usar-se o depurador (_debugger_):

*   Criar um _breakpoint_ no servidor, na linha desejada
*   Inspeccione o valor das variáveis relevantes

Problema resolvido?  
     [Sim!](http://www.phdcomics.com/comics/archive.php?comicid=180)  
Retomar o exercício:

1.  **Modificar os programas para que o servidor responda ao cliente com uma mensagem de confirmação.**
2.  ... o resto do enunciado será entregue no início da aula.

## Entrega da solução

<span style="color:red;font-size:90%">A solução do exercício desta aula **não** conta para a avaliação, mas deverá ser entregue da forma descrita abaixo.</span>

Fénix, Avaliação, Projetos, **mini Exercício 0**

A solução completa deverá ser submetida no Fénix **antes do fim da sua aula de laboratório**.  
Trabalhos submetidos depois da hora de fim da aula não serão considerados.

**Ter atenção ao seguinte:**

*   Só serão aceites trabalhos de alunos que estiveram presentes no laboratório.
*   Assegure-se que a solução é enviada em formato ZIP e que não contém código compilado.  
    (faça `mvn clean` antes de zipar)
*   O servidor deve executar com o comando: `mvn package exec:java`
*   O cliente deve executar com o comando: `mvn compile exec:java`

## Aprender mais!

Vai valer a pena regressar a esta aula mais tarde e aprender mais!

### Ficheiros de configuração

*   [Exemplo de aplicação Java com configuração ![ZIP](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/zip.png)](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/java-app_config.zip) - utiliza ficheiro com propriedades de configuração, algumas delas preenchidas dinamicamente pelo Maven

### Bibliotecas como módulos Maven

*   [Exemplo de biblioteca Java ![ZIP](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/zip.png)](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/java-lib.zip) - uma biblioteca permite agrupar um conjunto de classes comuns, que podem ser usadas por outros programas. O comando `mvn install` disponibiliza o módulo no repositório local. O módulo instalado pode depois ser usado como dependência através das coordenadas (_groupId_, _artifactId_, e _version_).

### JUnit + JMockit

*   [Introdução ao JUnit](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/junit/index.html)
*   [Introdução ao JMockit](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/jmockit/index.html)

*   [Exemplo de aplicação Java com testes JUnit ![ZIP](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/zip.png)](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/junit-app.zip) - utiliza o Maven para compilar e testar: `mvn test`
*   [Exemplo de aplicação Java com testes JMockit ![ZIP](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/zip.png)](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/02-tools/jmockit-app.zip) - utiliza o Maven para compilar e testar, com objectos simulados.

* * *

 ![IST-LOGO](https://camo.githubusercontent.com/8eb8ec735b6ac78c6495caa84c7ea6c02a5ca966/687474703a2f2f6f7765656b2e7465636e69636f2e756c6973626f612e70742f6173736574732f696d672f706172746e65722d6973742e706e67)
 
© Sistemas Distribuídos, [Dep. Eng. Informática](http://www.dei.tecnico.ulisboa.pt/), [Técnico Lisboa](http://www.ist.eu)  