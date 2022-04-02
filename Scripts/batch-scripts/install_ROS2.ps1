# Power Shell Script to install ROS2 on Window OS.

#Please run the following command in Powershell opened in 'administrative' mode, before running this script.
#Set-ExecutionPolicy unrestricted

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


Invoke-WebRequest -Uri $URL_for_openCV -OutFile $current_directory_path

Expand-Archive "$($current_directory_path)$fileName_of_openCV)" -DestinationPath $destination_for_unzipping_openCV

setx -m OpenCV_DIR C:\opencv


choco install -y cmake

[Environment]::SetEnvironmentVariable("PATH", $Env:PATH + ";C:\opencv", [EnvironmentVariableTarget]::Machine)

$URL_for_asio_1_12_1_nupkg = "https://github.com/ros2/choco-packages/releases/download/2020-02-24/asio.1.12.1.nupkg"
$URL_for_bullet_2_89_0_nupkg = "https://github.com/ros2/choco-packages/releases/download/2020-02-24/bullet.2.89.0.nupkg"
$URL_for_cunit_2_1_3_nupkg = "https://github.com/ros2/choco-packages/releases/download/2020-02-24/cunit.2.1.3.nupkg"
$URL_for_eigen-3_3_4_nupkg = "https://github.com/ros2/choco-packages/releases/download/2020-02-24/eigen.3.3.4.nupkg"
$URL_for_tinyxml-usestl_2_6_2_nupkg = "https://github.com/ros2/choco-packages/releases/download/2020-02-24/tinyxml-usestl.2.6.2.nupkg"
$URL_for_tinyxml2_6_0_0_nupkg = "https://github.com/ros2/choco-packages/releases/download/2020-02-24/tinyxml2.6.0.0.nupkg"
$URL_for_log4cxx_0_10_0_nupkg ="https://github.com/ros2/choco-packages/releases/download/2020-02-24/log4cxx.0.10.0.nupkg"


Invoke-WebRequest -Uri $URL_for_asio_1_12_1_nupkg -OutFile $current_directory_path
Invoke-WebRequest –Uri $URL_for_bullet_2_89_0_nupkg -OutFile $current_directory_path
Invoke-WebRequest –Uri $URL_for_cunit_2_1_3_nupkg -OutFile $current_directory_path
Invoke-WebRequest –Uri $URL_for_eigen-3_3_4_nupkg -OutFile $current_directory_path
Invoke-WebRequest –Uri $URL_for_tinyxml-usestl_2_6_2_nupkg -OutFile $current_directory_path
Invoke-WebRequest –Uri $URL_for_tinyxml2_6_0_0_nupkg -OutFile $current_directory_path
Invoke-WebRequest –Uri $URL_for_log4cxx_0_10_0_nupkg -OutFile $current_directory_path

choco install -y -s <PATH\TO\DOWNLOADS> asio cunit eigen tinyxml-usestl tinyxml2 log4cxx bullet

#Installing Python dependencies
python -m pip install -U catkin_pkg cryptography empy ifcfg lark-parser lxml netifaces numpy opencv-python pyparsing pyyaml setuptools rosdistro

#RQt Dependencies
python -m pip install -U pydot PyQt5

#Installing GraphViz and appending it to Path
choco install graphviz
[Environment]::SetEnvironmentVariable("PATH", $Env:PATH + ";C:\Program Files\Graphviz\bin", [EnvironmentVariableTarget]::Machine)

echo "Downloading ROS2"

Invoke-WebRequest -Uri $URL_for_ROS2 -OutFile $current_directory_path$fileName_of_ROS2

#$Invoke-WebRequest -Uri $URL_for_ROS2 -OutFile  $current_directory_path$fileName_of_ROS2

echo "Installing ROS2"
Expand-Archive -LiteralPath "$($current_directory_path)$fileName_of_ROS2" -DestinationPath "$destination_for_unzipping_ROS2"

#Downloading RTI Connext for Visual Studio 2017
echo " Downloading RTI Connext for Visual Studio 2017, 2015"
Invoke-WebRequest -Uri "https://s3.amazonaws.com/RTI/Bundles/6.1.0/Evaluation/rti_connext_dds-6.1.0-lm-x64Win64VS2017.exe" -OutFile $current_directory_path

echo " Downloading RTI Connext for Visual Studio 2015"
Invoke-WebRequest -Uri "https://s3.amazonaws.com/RTI/Bundles/6.1.0/Evaluation/rti_connext_dds-6.1.0-lm-x64Win64VS2015.exe" -OutFile $current_directory_path

#Moving the Zip file to the path as directed by ROS2 Manual
echo "Moving ROS2 file to correct path as given on ROS2 Docs."
Move-Item C:\dev\ros2_foxy\ros2-windows C:\temp_folder_for_Ros2
Move-Item C:\temp_folder_for_Ros2\* C:\dev\ros2_foxy
Remove-Item C:\temp_folder_for_Ros2
#Making Execution Policy restricted again

Set-ExecutionPolicy Restricted


echo "Installation Complete"

echo "Please rename the RTI Connext Directory at (C:\Program Files\rti_connext_dds-6.1.0) to C:\Program Files\rti_connext_dds-5.3.1."
