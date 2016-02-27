
# Invocação de procedimentos remotos com SUN RPC

## Objectivos da semana

*   Distribuir uma aplicação originalmente centralizada usando o SUN RPC
*   Aprofundar os conhecimentos sobre RPC


## Materiais de apoio à aula

*   [Capítulo sobre SUN RPC da 2ª Edição do livro "Distributed Systems: Concepts and Design"](http://www.cdk4.net/wo/additional/rmi/Ed2/SunRPC.pdf)

## Exercício a resolver até ao fim da aula

####  Numa máquina Linux/Unix, descarregue e descomprima o [código fonte de um servidor do Jogo do Galo/Tic Tac Toe, baseado em Sun RPC](http://disciplinas.tecnico.ulisboa.pt/~leic-sod.daemon/2015-2016/labs/03-rpc/ttt.zip).  

Sugestões:

*   Caso não disponha de máquina Unix/Linux, use a sua conta no <code>sigma.tecnico.ulisboa.pt</code>.
Pode usar um dos vários editores de texto no terminal: <code>nano</code>, <code>vi</code>, <code>emacs</code>, <code>pico</code>, <code>joe</code>, ...

*   Para evitar conflitos com outros RPC na mesma máquina deverá editar o identificador do programa (<code>ttt.x</code>) e substituir os últimos 5 dígitos pelo seu número de aluno

*   Se quiser correr o laboratório no seu próprio computador é necessário instalar os seguintes pacotes Linux (os nomes exactos variam conforme a distribuição usada): <code>rpcbind</code> e <code>nfs-kernel-server</code>.

Em algumas máquinas, que recorrem ao rpcbind, pode ser necessário lancar esta aplicação usando <code>rpcbind -wi</code> ou então usando privilégios de administração <code>(sudo)</code> no caso de obter a seguinte mensagem de erro: _"Cannot register service: RPC: Authentication error; why = Client credential too weak"


####  Estude a interface remota deste servidor (ficheiro <code>ttt.x</code>) e explore a implementação do servidor para compreender como cada procedimento remoto está implementado (restantes ficheiros iniciados em <code>ttt</code>).

*   Para que serve o _mutex_ usado no ficheiro ttt_lib.c?

#####  Execute na consola: <code>> rpcgen ttt.x</code> para que o SUN RPC gere os vários ficheiros de suporte à aplicação distribuída.  

#####  Depois execute:  
<code>> rpcgen -Sc ttt.x > ttt_client.c</code> para gerar um exemplo de um cliente. (existe também a opção <code>-Ss</code> para gerar um exemplo de servidor)  


####  Estude os ficheiros gerados.

*  Onde estão as rotinas de conversão de tipos de dados?

*  Onde é chamada a função <code>clnt_call()</code>?

*  Que ficheiros pertencem ao cliente, ao servidor, e a ambos? (consulte também a <code>Makefile</code>)

*  Que ficheiros estão incompletos e devem ser alterados pelo programador?

*  Qual o protocolo que o cliente e servidor usam para comunicar?  


####  Pretende-se também que haja um processo cliente (que possivelmente corre em máquina diferente que o servidor) que interage com os jogadores e que invoca as funções do servidor remotamente, via SUN RPC.  

A lógica desse cliente já está programada em <code>local_main.c</code>, mas esse ficheiro está feito assumindo chamadas locais.  

Com base no <code>local_main.c</code>, modifique o ficheiro <code>ttt_client.c</code> por forma a obter um cliente do servidor remoto.  

Sugestão: 

* copie o código da função main do <code>local_main.c</code> para dentro do método <code>ttt_1</code> de <code>ttt_client.c</code> 

* procure as linhas onde existem chamadas locais às funções <code>currentBoard</code>, <code>play</code> e <code>checkWinner</code> e substitua essas chamadas pelos exemplos de chamadas remotas que já existem no ficheiro <code>ttt_client.c</code> gerado 

* Não se esqueça de verificar o retorno da chamada remota ao servidor e garantir o tratamento adequado em caso de erro.  

Utilize o comando <code>make</code> para compilar.  


####  Lance o servidor e experimente jogar remotamente através do cliente construído.  

Para tal, execute na consola:  

* <code>> ./ttt_server &</code> (lança servidor em fundo - _background_)  

* <code>> ./ttt_client localhost</code> (lança cliente para jogar em servidor registado na própria máquina (localhost)  


####  Pode consultar o estado dos processos com o comando <code>ps</code> e terminar instâncias com o comando <code>kill</code>.

O resto do enunciado será entregue na aula. O objectivo será estender a solução resultante do enunciado acima com mais procedimentos ou modificar alguns dos seus procedimentos actuais.


## Entrega da solução

Fénix, Avaliação, Projetos, **mini Exercício 1 - Sun RPC**

A solução completa deverá ser submetida no Fénix **antes do fim da sua aula de laboratório**.  
Trabalhos submetidos depois da hora de fim da aula não serão considerados.


**Ter atenção ao seguinte:**

*   Só serão aceites trabalhos de estudantes que estiveram presentes no laboratório.
*   Assegure-se que a solução é enviada em formato ZIP e que não contém código compilado.  
(faça <code>make clean</code> antes de zipar)
*   Deverá incluir um ficheiro <code>respostas.txt</code> com as respostas às perguntas do enunciado do exercício.
*   Deverá também incluir um ficheiro <code>instrucoes.txt</code> com resumo da funcionalidade implementada e com instruções para colocar o programa a funcionar como esperado.  


Por exemplo:

*   A funcionalidade pedida foi total/parcialmente implementada **...**
*   Para compilar: <code>make</code>
*   O servidor deve executar com o comando: <code>./ttt_server &</code>
*   O cliente deve executar com o comando: <code>./ttt_client localhost</code>


* * *


![IST-LOGO](https://camo.githubusercontent.com/8eb8ec735b6ac78c6495caa84c7ea6c02a5ca966/687474703a2f2f6f7765656b2e7465636e69636f2e756c6973626f612e70742f6173736574732f696d672f706172746e65722d6973742e706e67)

© Sistemas Distribuídos, [Dep. Eng. Informática](http://www.dei.tecnico.ulisboa.pt/), [Técnico Lisboa](http://www.ist.eu)  