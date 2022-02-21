# Power Shell Script to install ROS2 on Window OS. 
# ----------------------------------- Script Start ----------------------------------- 

#Installing Chocolatey
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))

#Making Execution Policy restricted again
Set-ExecutionPolicy Restricted

#Installing Python 3.8.3
choco install -y python --version 3.8.3

#Installing Visual C++ Redistributables
choco install -y vcredist2013 vcredist140