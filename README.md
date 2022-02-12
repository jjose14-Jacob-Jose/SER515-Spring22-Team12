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


- Install OpenSSL:

Download the Win64 OpenSSL v1.1.1L OpenSSL installer from https://slproweb.com/products/Win32OpenSSL.html. Scroll to the bottom of the page and download Win64 OpenSSL v1.1.1L. Don’t download the Win32 or Light versions.

Run the installer with default parameters, as the following commands assume you used the default installation directory.

This command sets an environment variable that persists over sessions:

setx -m OPENSSL_CONF "C:\Program Files\OpenSSL-Win64\bin\openssl.cfg"

You will also need to append the OpenSSL-Win64 bin folder to your PATH. You can do this by clicking the Windows icon, typing “Environment Variables”, then clicking on “Edit the system environment variables”. In the resulting dialog, click “Environment Variables”, then click “Path” on the bottom pane, finally click “Edit” and add the path below.

C:\Program Files\OpenSSL-Win64\bin\

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