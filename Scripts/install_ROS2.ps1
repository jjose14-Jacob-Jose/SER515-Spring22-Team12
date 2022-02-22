# Power Shell Script to install ROS2 on Window OS. 

$current_directory_path = Get-Location

#URLs for downloading
$URL_visual_studio_2019_community= "https://visualstudio.microsoft.com/thank-you-downloading-visual-studio/?sku=Community&rel=16&src=myvs&utm_medium=microsoft&utm_source=my.visualstudio.com&utm_campaign=download&utm_content=vs+community+2019"

# ----------------------------------- Script Start ----------------------------------- 

#Installing Chocolatey
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))

#Making Execution Policy restricted again
Set-ExecutionPolicy Restricted

#Installing Python 3.8.3
choco install -y python --version 3.8.3

#Installing Visual C++ Redistributables
choco install -y vcredist2013 vcredist140

#Installing OpenSLL
setx -m OPENSSL_CONF "C:\Program Files\OpenSSL-Win64\bin\openssl.cfg"

#Downloading Visual Studio 2019

#Invoke-WebRequest -Uri $visual_studio_2019_community_URL -OutFile $current_directory_path
