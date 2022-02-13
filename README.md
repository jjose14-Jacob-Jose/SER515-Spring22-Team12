# SER515-Spring22-Team12
GitHub repo for SER 515 Spring 22 Team 12


This repository will have all the artifacts for SER 515 - Group 12, Simulation Rover.

Built With (This space will keep updated incrementally)

Unity 3D - 2023 26f1 ROS 2 SLAM ODOM Python Rviz Docker

Prerequisites

Generate public key and add it into github account Open command prompt and execute ssh-keygen By default, the system will save the keys to C:\Users\your_username/.ssh/id_rsa. Navigate to C:\Users\your_username/.ssh folder anc copy id_rsa.pub Add tis key to github account.

Clone the repo git clone -b master https://github.com/ksharm53/SER515-Spring22-Team12.git

Usage

Contact

Team Details 

- Jacob Jose 
- Kanav Sharma 
- Nihal Singh
- Virinchi
- Krishna Pandya 
- Jay Patel


--------------------------------------------------------------------------------------------------------------------------------------------
Installation
--------------------------------------------------------------------------------------------------------------------------------------------
-Chocolatey

Install Chocolatey

Follow steps from the following link: https://chocolatey.org/install

First, ensure that you are using an administrative shell - you can also install as a non-admin, check out Non-Administrative Installation.
Install with powershell.exe


Run Get-ExecutionPolicy. If it returns Restricted, then run Set-ExecutionPolicy AllSigned or Set-ExecutionPolicy Bypass -Scope Process.
Now run the following command:

Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))

Paste the copied text into your shell and press Enter.

Wait a few seconds for the command to complete.

If you don't see any errors, you are ready to use Chocolatey! Type choco or choco -? now, or see Getting Started for usage instructions.

--------------------------------------------------------------------------------------------------------------------------------------------
-Python

Open a Command Prompt and type the following to install Python via Chocolatey:
Check whether there are any versions other than 3.8.3 
if they are present 
uninstall python via System control panel

choco install -y python --version 3.8.3

ROS 2 expects the python installation to be available in directory  C:\python38. Double check that it is installed there.

--------------------------------------------------------------------------------------------------------------------------------------------
-Visual C++ Redistributables

Open a Command Prompt and type the following to install them via Chocolatey:

choco install -y vcredist2013 vcredist140
--------------------------------------------------------------------------------------------------------------------------------------------
- Install OpenSSL

Download the Win64 OpenSSL v1.1.1L OpenSSL installer from ( https://slproweb.com/products/Win32OpenSSL.html ). 
Scroll to the bottom of the page and download Win64 OpenSSL v1.1.1L. Don’t download the Win32 or Light versions.

Run the installer with default parameters, as the following commands assume you used the default installation directory.

This command sets an environment variable that persists over sessions:

< setx -m OPENSSL_CONF "C:\Program Files\OpenSSL-Win64\bin\openssl.cfg" >

You will also need to append the OpenSSL-Win64 bin folder to your PATH. 
You can do this by clicking the Windows icon, typing “Environment Variables”, then clicking on “Edit the system environment variables”. 
In the resulting dialog, click “Environment Variables”, then click “Path” on the bottom pane, finally click “Edit” and add the path below.

< C:\Program Files\OpenSSL-Win64\bin\ >

-------------------------------------------------------------------------------------------------------------------------------------------- 

- Install Visual Studio

Install Visual Studio 2021.

If you already have a paid version of Visual Studio 2021 (Professional, Enterprise), skip this step.

Microsoft provides a free of charge version of Visual Studio 2021, named Community, which can be used to build applications that use ROS 2. 
You can download the installer directly through this link. ( https://code.visualstudio.com/updates/v1_64 )

Make sure that the Visual C++ features are installed.

An easy way to make sure they’re installed is to select the Desktop development with C++ workflow during the install. 

Make sure that no C++ CMake tools are installed by unselecting them in the list of components to be installed.   
------------------------------------------------------------------------------------------------------------------------------------------- 
- Install OpenCV:

Some of the examples require OpenCV to be installed.

You can download a precompiled version of OpenCV 3.4.6 from https://github.com/ros2/ros2/releases/download/opencv-archives/opencv-3.4.6-vc16.VS2019.zip .

Assuming you unpacked it to C:\opencv, type the following on a Command Prompt (requires Admin privileges):

setx -m OpenCV_DIR C:\opencv

Since you are using a precompiled ROS version, we have to tell it where to find the OpenCV libraries. You have to extend the PATH variable to C:\opencv\x64\vc16\bin.



--------------------------------------------------------------------------------------------------------------------------------------------
-Install Dependencies

You will need to append the CMake bin folder C:\Program Files\CMake\bin to your PATH.

Please download these packages from this GitHub repository.

asio.1.12.1.nupkg

bullet.2.89.0.nupkg

cunit.2.1.3.nupkg

eigen-3.3.4.nupkg

tinyxml-usestl.2.6.2.nupkg

tinyxml2.6.0.0.nupkg

log4cxx.0.10.0.nupkg

Once these packages are downloaded, open an administrative shell and execute the following command:

choco install -y -s <PATH\TO\DOWNLOADS> asio cunit eigen tinyxml-usestl tinyxml2 log4cxx bullet
Please replace <PATH\TO\DOWNLOADS> with the folder you downloaded the packages to.

You must also install some python dependencies for command-line tools:

python -m pip install -U catkin_pkg cryptography empy ifcfg lark-parser lxml netifaces numpy opencv-python pyparsi
-------------------------------------------------------------------------------------------------------------------------------------------- 
- Install Qt5:

This section is only required if you are building rviz.

First get the installer from Qt’s website:

https://www.qt.io/download

Select the Open Source version and then the Qt Online Installer for Windows.

Run the installer and install Qt5.

We recommend you install it to the default location of C:\Qt, but if you choose somewhere else, make sure to update the paths below accordingly. When selecting components to install, the only thing you absolutely need is the appropriate MSVC 64-bit component under the Qt -> Qt 5.15.0 tree. We’re using 5.15.0 as of the writing of this document and that’s what we recommend since that’s all we test on Windows, but later Qt5 versions will probably work too. Be sure to select MSVC 2019 64-bit. After that, the default settings are fine.

Finally, set the Qt5_DIR environment variable in the cmd.exe where you intend to build so that CMake can find it:

set Qt5_DIR=C:\Qt\5.15.0\msvc2019_64
set QT_QPA_PLATFORM_PLUGIN_PATH=C:\Qt\5.15.0\msvc2019_64\plugins\platforms

You could set it permanently with below instead. Use Admin access for the same.

setx -m Qt5_DIR C:\Qt\5.15.0\msvc2019_64 
setx -m QT_QPA_PLATFORM_PLUGIN_PATH C:\Qt\5.15.0\msvc2019_64\plugins\platforms 

-------------------------------------------------------------------------------------------------------------------------------------------- 
-RQT Dependencies

Open Command Prompt with administrative privileges and run the following commands. 

python -m pip install -U pydot PyQt5

choco install graphviz

Then a directory will be created at the location 'C:\Program Files\Graphviz\bin.

Add the 'bin' of this directory (Graphviz) to your environmental variables PATH.

-------------------------------------------------------------------------------------------------------------------------------------------- 
-Downloading ROS2

Go to "https://github.com/ros2/ros2/releases" and download the latest package for Windows. It should have a name like 'ros2-foxy-*-windows-AMD64.zip'. 

Here, you can click on the following URL to download ROS 2 Foxy.
"https://github.com/ros2/ros2/releases/download/release-foxy-20220208/ros2-foxy-20220208-windows-release-amd64.zip".


Unpack the zip file to the directory "C:\dev\ros2_foxy"

-------------------------------------------------------------------------------------------------------------------------------------------- 
-Environment Setup

Start a command shell and source the ROS 2 setup file to set up the workspace:

call C:\dev\ros2_foxy\local_setup.bat

It is normal that the previous command, if nothing else went wrong, outputs “The system cannot find the path specified.” exactly once.

-------------------------------------------------------------------------------------------------------------------------------------------- 

-Examples

In a command shell, set up the ROS 2 environment as described and then run a C++ talker:

ros2 run demo_nodes_cpp talker

Start another command shell and run a Python listener:

ros2 run demo_nodes_py listener