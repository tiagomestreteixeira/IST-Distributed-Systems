# Software

Para realizar os exercícios de laboratório e o projecto de SD é necessário instalar um conjunto de ferramentas e servidores. Todo o software listado abaixo está disponível em sistemas Windows, Linux e Mac.  

Nos caminhos de ficheiros (_paths_) em Windows usa-se a barra \ como separador; nos caminhos Linux e Mac usa-se /

As instalações seguintes devem ser feitas numa pasta que **não** tenha espaços nem caracteres acentuados no nome, para evitar _bugs_ existentes e ainda não resolvidos, sobretudo nas ferramentas Java em Windows.  
Nome de pasta raíz recomendada: **<code>C:\Java</code>**  
Nomes de pastas a evitar: <code>C:\Program Files</code>, <code>C:\Users\João</code>

A maior parte das ferramentas necessita de configurar **variáveis de ambiente**.  
O procedimento para definir variáveis de ambiente depende do sistema operativo: [Windows](http://superuser.com/questions/25037/change-environment-variables-as-standard-user-windows-7), [Linux](http://www.cyberciti.biz/faq/set-environment-variable-linux/) e [Mac](http://www.mkyong.com/mac/how-to-set-environment-variables-on-mac-os-x/).

* * *

## Java Developer Kit, JDK** (que inclui o Java Runtime Environment, JRE)  
Ambiente para programação na linguagem Java

*   Obter

*   [JDK 8u72](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

*   Instalar
*   Configurar

*   Definir variável de ambiente JAVA_HOME com o caminho para a pasta de instalação do JDK
*   Acrescentar JAVA_HOME/bin à variável de ambiente PATH
*   Executar comando <code>javac -version</code> para confirmar

## Apache Maven, MVN
Ferramenta de linha de comando para a gestão do ciclo de vida de uma aplicação, incluindo a gestão de dependências de bibliotecas.

*   Obter

*   [MVN 3.3.3](http://maven.apache.org/download.cgi) <small>(preferência por esta versão por ser a utilizada internamente no Eclipse Mars.1)</small>

*   Instalar
*   Configurar

*   Definir variável de ambiente M2_HOME com o caminho para a pasta de instalação
*   Acrescentar M2_HOME/bin à PATH
*   Executar comando <code>mvn --version</code> para confirmar

## Git  
Ferramenta de linha de comando para fazer controlo de versões.

*   Obter

*   [Git 2.x](http://git-scm.com/download/) <small>(escolher a versão estável mais recente disponível para a plataforma)</small>

*   Instalar

*   [Installing Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

*   Configurar

*   Executar comando <code>git --version</code> para confirmar

## Eclipse for Java Enterprise Edition, Eclipse JEE
Ambiente integrado de desenvolvimento para a plataforma Java, versão empresarial

*   Obter o arquivo que contém o executável de Eclipse Mars e ficheiros associados:

*   [Eclipse JEE 4.5.1 - Mars Service Release 1](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars1)<small></small>

*   Atenção: se tem instalado no seu sistema operativo o JDK 32 bits, deve obter o Eclipse 32 bits; se instalou o JDK 64 bits, deve obter o Eclipse 64 bits.
*   Nota: o arquivo para Windows vem em formato **.zip**, para outros sistemas operativos vem em **.tar.gz**.

*   Instalar:

*   Extrair o arquivo para um diretório com permissões de escrita.
<small>Possível resultado: <code>C:\Users\john\Documents\eclipse</code> em Windows, ou <code>/home/john/Documents/eclipse</code> em Linux para um utilizador chamado **john**</small>

*   Configurar:

*   Especificar o JDK como Standard VM
**Nota: só deverá ser necessário este passo em Windows.**

*   Window -> Preferences -> Java -> Installed JREs -> Add...
*   Indicar o caminho até ao diretório do JDK: ex. <code>C:\Java\jdk1.8.0_72</code>
*   Confirmar que as "Installed JREs" apenas faz referência ao JDK instalado nas opções ativadas

*   **Conectores m2e** (maven 2 eclipse)

*   Window -> Preferences -> Maven -> Discovery e clicar em "Open catalog".
*   Seleccionar:

*   m2e connector for jaxws-maven-plugin
*   m2e connector for maven-dependency-plugin
*   m2e connector for org.codehaus.mojo:jaxb2-maven-plugin and org.jvnet.jaxb2.maven2:maven-jaxb2-plugin
*   m2e-apt
*   m2e-egit

## Apache jUDDI  
Servidor de nomes para Web Services que segue a norma UDDI (Universal Description, Discovery, and Integration)

*   Obter

*   [jUDDI 3.3.2](http://disciplinas.tecnico.ulisboa.pt/leic-sod/2015-2016/download/juddi-3.3.2_tomcat-7.0.64_9090.zip) <small>(configured for port **9090**)</small>

*   Instalar

*   Em Linux ou Mac, tornar os _scripts_ de lançamento executáveis:  
<code>chmod +x juddi-3.3.2_tomcat-7.0.64_9090/bin/*.sh</code>
*   Para lançar o servidor, basta executar o seguinte comando na pasta <code>juddi-3.3.2_tomcat-7.0.64_9090/bin</code>:

*   <code>startup.sh</code> (Linux e Mac)
*   <code>startup.bat</code> (Windows)

*   Para confirmar funcionamento, aceder à página de índice do jUDDI, que dá também acesso à interface de administração  
[http://localhost:9090/juddiv3/](http://localhost:9090/juddiv3/)

*   utilizador:senha <code>uddiadmin:da_password1</code>

* * *

  ![IST-LOGO](https://camo.githubusercontent.com/8eb8ec735b6ac78c6495caa84c7ea6c02a5ca966/687474703a2f2f6f7765656b2e7465636e69636f2e756c6973626f612e70742f6173736574732f696d672f706172746e65722d6973742e706e67)
 
© Sistemas Distribuídos, [Dep. Eng. Informática](http://www.dei.tecnico.ulisboa.pt/), [Técnico Lisboa](http://www.ist.eu)  