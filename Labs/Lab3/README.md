# Lab 3 - Java RMI

## Objectivos

*   Distribuir uma aplicação originalmente centralizada usando o Java RMI
*   Aprofundar os conhecimentos sobre Java RMI
*   Tomar contacto com os mecanismos de passagem de classes do Java RMI

## No laboratório:

*   Esclarecer dúvidas
*   Terminar o exercício


## Documentação

*   Capítulo 5.5 Java RMI do livro principal da cadeira (Coulouris "Distributed Systems: Concepts and Design")

## Enunciado

Partindo de um Jogo do Galo (Tic Tac Toe) feito para um cenário local, pretende-se desenvolver uma variante do jogo onde a parte computacionalmente mais pesada é realizada por um servidor remoto.

_Sugestão: nas alíneas seguintes, corra cliente e servidor numa máquina não partilhada com outros grupos, para evitar conflitos com outros grupos (ou seja, use a máquina do laboratório e não o sigma)._

1.  Descarregue e descomprima o código fonte da aplicação Jogo do Galo/Tic Tac Toe  
([servidor![ZIP](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/zip.png)](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/04-rmi/ttt-rmi-server.zip), [cliente![ZIP](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/zip.png)](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/04-rmi/ttt-rmi-client.zip)).
1.  Importe o projecto no eclipse, [seguindo os passos aqui indicados](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/02-tools/eclipse/configure-maven-project/index.html).
2.  Estude os principais ficheiros do pacote com a implementação do jogo (Game.java e TTT.java).
3.  Compile e experimente o jogo (pelo Eclipse ou executando <code>mvn package appassembler:assemble</code> seguido de <code>target\appassembler\bin\ttt-rmi-server</code> numa consola **exterior ao Eclipse**).
2.  Pretende-se que a classe <code>TTT.java</code>, que implementa o jogo, passe a ser invocável remotamente.  
Dessa forma, permitir-se-á que haja um cliente remoto (que possivelmente corre em máquina diferente que a máquina que serve o jogo) que interage com os jogadores e que invoca as funções do servidor via Java RMI (Remote Method Invocation).
1.  Comece por desenhar a interface remota do servidor numa interface chamada <code>TTTService</code>. A interface deve expor todas as funções remotas que o cliente precisa de invocar. Para ser uma interface remota, precisa também de herdar de <code>java.rmi.Remote</code> e cada um dos seus métodos deve lançar uma <code>java.rmi.RemoteException</code>.  
Consulte o [exemplo de interface remota apresentado no livro](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/04-rmi/ShapeList.java) para ajuda.
2.  Transforme a classe <code>TTT</code> para que passe a implementar a interface remota <code>TTTService</code>. Para que instâncias desta classe possam ser objectos remotos, modifique a definição da classe <code>TTT</code> para que ela passe a herdar de <code>java.rmi.server.UnicastRemoteObject</code> e acrescente um construtor que lance excepção <code>RemoteException</code>.  
Consulte o [exemplo da classe shapeListServant apresentado no livro](./ShapeListServant.java) para ajuda.
3.  No projecto servidor, crie uma nova classe com método <tt>main</tt>, onde correrá o servidor.  
No método <code>main</code> deverá:
1.  Instanciar um objecto remoto do tipo TTT, eConsulte o [exemplo da classe ShapeListServer apresentado no livro](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/04-rmi/ShapeListServant.java) para ajuda.  
Não se esqueça de actualizar o ficheiro <code>pom.xml</code>.
4.  Abra agora o ficheiro fonte da classe <code>ttt.Client</code>.
1.  Baseando-se na classe ttt.Game do projecto do servidor, implemente um cliente remoto que, com base nos comandos recebidos pela consola local, invoca métodos do jogo remoto. Assuma que ambos os jogadores de cada jogo usam o mesmo cliente.  
Consulte o [exemplo do cliente apresentado no livro](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/04-rmi/ShapeListClient.java) para ajuda.
2.  Não se esqueça de na chamada ao método <code>Naming.lookup</code>, definir correctamente o URL que localiza o objecto, na forma: <code>//host:port/name</code>, em que <code>host</code> e <code>port</code> definem a máquina e o porto onde corre o <code>rmiregistry</code> (respectivamente) onde foi registado o objecto remoto e <code>name</code> é o nome que foi atribuído ao objecto pelo servidor quando chamou <code>rebind</code>.
3.  Experimente lançar o servidor e depois um cliente para jogar.
4.  Responda às seguintes questões:
1.  Quando se usa SUN RPC é gerado código para converter os dados de e para um formato de rede. O que acontece quando se usa RMI?
2.  Das classes e interfaces Java que usou, quais as que pertencem apenas ao cliente, apenas ao servidor e a ambos?

O resto do enunciado será entregue na aula. O objectivo será estender a solução resultante do enunciado acima com mais procedimentos ou modificar alguns dos seus procedimentos actuais.

## Entrega da solução

Fénix, Avaliação, Projetos, **mini Exercício 2 - Java RMI**

A solução completa deverá ser submetida no Fénix **antes do fim da sua aula de laboratório**.  
Trabalhos submetidos depois da hora de fim da aula não serão considerados.  

**Ter atenção ao seguinte:**

*   Só serão aceites trabalhos de estudantes que estiveram presentes no laboratório.
*   Assegure-se que a solução é enviada em formato ZIP e que não contém código compilado.  
(faça <code>mvn clean</code> antes de zipar)
*   Deverá incluir um ficheiro <code>respostas.txt</code> com as respostas às perguntas do enunciado do exercício.
*   Deverá também incluir um ficheiro <code>instrucoes.txt</code> com resumo da funcionalidade implementada e com instruções para colocar o programa a funcionar como esperado.  
Por exemplo:

*   A funcionalidade pedida foi total/parcialmente implementada **...**
*   Para compilar: <code>mvn compile</code>
*   O servidor deve executar com o seguinte comando: <code>./target/appassembler/bin/ttt-rmi-server</code>
*   O cliente deve executar com o comando: <code>./target/appassembler/bin/ttt-rmi-client localhost</code>

### Ajuda adicional

*   Revisitar [Ferramentas](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/02-tools/index.html) (Java, Maven, Eclipse)

## Como seria um projecto Java RMI na realidade?

O projecto desenvolvido ao longo das alíneas seguintes inclui algumas simplificações importantes que normalmente não se observam num projecto real de Java RMI. Entre elas:

1.  Existe apenas uma instância de objecto remoto.  
Normalmente pode existir um número variado de interfaces e classes remotas, assim como de suas instâncias.
2.  Há um processo que aloja o objecto remoto e outro processo que obtém referência remota para essa objecto, numa clara distinção entre servidor e cliente.  
Na prática, um processo pode simultaneamente ser servidor de alguns objectos remotos e ter outras referências remotas (para objectos remotos noutros processos), sobre as qual invoca métodos (agindo também como cliente).
3.  No projecto acima nunca ocorre nenhuma situação de carregamento dinâmico de classes.  
Essa situação poderia, por exemplo, acontecer se um método remoto recebesse ou retornasse um objecto por valor. Nesse caso seria necessário definir alguns aspectos de segurança da JVM (em particular, um Security Manager e uma Security Policy).
4.  O RMIRegistry é lançado internamente pelo servidor na mesma JVM ( <code>LocateRegistry.createRegistry()</code>). O RMI Registry é normalmente um serviço autónomo que corre numa máquina virtual Java (JVM) separada do processo que instancia e solitica o registo de um objecto remoto. Neste caso, é necessário que os ficheiros com as interfaces remotas dos objectos a registar no Registry estejam disponíveis num URL definido no parâmetro "codebase" da JVM do processo servidor.  
Um exemplo de uma aplicação que usa RMI Registry como serviço autónomo pode ser consultado aqui:  
[servidor![ZIP](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/zip.png)](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/04-rmi/hello-rmi-server.zip), [cliente![ZIP](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/_img/zip.png)](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/labs/04-rmi/hello-rmi-client.zip).

* * *

![IST-LOGO](https://camo.githubusercontent.com/8eb8ec735b6ac78c6495caa84c7ea6c02a5ca966/687474703a2f2f6f7765656b2e7465636e69636f2e756c6973626f612e70742f6173736574732f696d672f706172746e65722d6973742e706e67)

© Sistemas Distribuídos 2016, [Dep. Eng. Informática](http://www.dei.tecnico.ulisboa.pt/), [Técnico Lisboa](http://www.ist.eu)  