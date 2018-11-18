## FMCat Workshop preparation recipes
Barcelona, Saturday NOV 17 2018, by Francesc Sans


### Mac OSX

Instal.lat **XCode** descarregant l'app des de AppStore. A continuació instal.lar XCode Command Line Tools
des de XCode>Preferences>General>Downloads>Components>Command Line Tools.
(Es un proces llarg)

*[recomanat]*
IDE
Instal·lar **Visual Studio Code**, des de https://code.visualstudio.com/download
Alternativament **IntelliJ** (trial), Eclipse (free) o altres.

**[requerit]** instal·lar **HomeBrew** (https://brew.sh)
```bash
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

*[recomanat]* instal·lar **iTerm2**
```bash
brew cask install iterm2
```
(sortir de Terminal i obrir iTerm2)

 instal·lar **ZSH** 
 
```bash
brew install zsh zsh-completions
```
 
*[recomanat]* Activar ZSH com shell del usuari en lloc de BASH

```bash
chsh -s $(which zsh)
```


*[recomanat]* Instal·lar "Oh-My-Zsh"
```bash
sh -c "$(curl -fsSL https://raw.githubusercontent.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"
```

*[requerit]* Instal·lar **GIT**
```bash
git --version
brew install git
```


*[requerit]* Instal·lar **Java JDK8**
```bash
brew cask install java8
```

*[requerit]* Instal·lar **Maven**
```bash
brew install maven
```

*[requerit]* Instal·lar **Gradle**
```bash
brew install gradle
```

*[requerit]* Instal·lar **NodeJS**
```bash
brew install nodejs
```

*[requerit]* Instal·lar **CURL**
```bash
brew install curl
```

*[requerit]* Instal·lar varis frameworks
```bash
npm install -g npm
npm install -g yo
npm install -g generator-jhipster
```

*[recomanat]* **SublimeText**
```bash
brew cask install sublime-text
```

alternativament instal·lador convencional des de https://www.sublimetext.com


*[recomanat]* **Visual Studio Code** ()
```bash
brew install visual-studio-code
```

alternativament instal·lador convencional des de https://code.visualstudio.com/download

*[recomanat]* Instal·lar **SourceTree** des de https://www.sourcetreeapp.com

*[recomanat]* **Springboot CLI**
```bash
brew tap pivotal/tap
brew install springboot
```




### WINDOWS

Es important tenir instal.lat **.NET Framework** (https://www.microsoft.com/net/download)
Descarregar la ultima versió i executar el setup.exe. (Es una proces llarg)


*[requerit]* Instal·lar **Chocolatey**, versió open source, free. Descarregar instal·lador a https://chocolatey.org
Si ja esta instal·lat, verificar instal·lacions existents executant:
```bash
choco list --local-only
``` 

Alternativament instal.lar **Scoop** (), te receptes similars a Cocolatey.
Es interessant instal-lar els dos sistemes.

```bash
iex (new-object net.webclient).downloadstring('https://get.scoop.sh')
```

Instal·lar diverses aplicacions i frameworks...

*[requerit]* Instal·lar **NodeJS**

```bash
choco install nodejs
```

*[requerit]* Instal·lar **JHipster**

```bash
 choco install jhipster
```

*[requerit]* Instal·lar **CURL**

```bash
 choco install curl
```
 
*[recomanat]* **Springboot CLI**

```bash
 choco install spring-boot-cli --version 2.0.4
```


*[recomanat]* Instal·lar SublimeText 3, des de https://www.sublimetext.com

*[recomanat]* Instal·lar SourceTree des de https://www.sourcetreeapp.com

*[recomanat]* Visual Studio Code des de https://code.visualstudio.com/download






