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

-------------------------------------------------------------------------------------------------------------------------------------------- 

Gazebo (Windows)
 - Prerequisites: 30Gb free disk space
 
Installation:

- Create directory in the root
  mkdir gz-ws
  cd gz-ws

- Download all below dependencies and extract into folder created previously
  https://s3.amazonaws.com/osrf-distributions/win32/deps/curl-7.57.0-vc15-x64-dll-MD.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/libyaml-0.1.7-vc15-x64-md.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/dlfcn-win32-vc15-x64-dll-MD.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/jsoncpp-1.8.4-vc15-x64-dll-MD.zip  
  https://s3.amazonaws.com/osrf-distributions/win32/deps/protobuf-3.4.1-vc15-x64-dll-MD.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/libzip-1.4.0_zlip-1.2.11_vc15-x64-dll-MD.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/zziplib-0.13.62-vc12-x64-release-debug.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/FreeImage3180Win32Win64.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/boost_1_67_0.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/ogre-sdk-1.10.12-vc15-x64.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/bzip2-1.0.6-vc12-x64-release-debug.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/tbb43_20141023oss_win.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/qt-opensource-windows-x86-msvc2015_64-5.7.0.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/qwt_6.1.2~osrf_qt5.zip
  https://s3.amazonaws.com/osrf-distributions/win32/deps/libzmq-4.2.3_cppzmq-4.2.2_vc15-x64-dll-MD.zip

- Install CMake and add it into the path
  http://www.cmake.org/download/

- Install Ruby and add it into system path
  http://rubyinstaller.org/downloads/  
  
- Clone below into folder created
   CMake  : git clone https://github.com/ignitionrobotics/ign-cmake -b ign-cmake0
   Common : git clone https://github.com/ignitionrobotics/ign-common -b ign-common1
   Fuel Tools  : git clone https://github.com/ignitionrobotics/ign-fuel-tools -b ign-fuel-tools1
   Math : git clone https://github.com/ignitionrobotics/ign-math -b ign-math4
   Ignition Msgs : git clone https://github.com/ignitionrobotics/ign-msgs -b ign-msgs1
   Transport :git clone https://github.com/ignitionrobotics/ign-transport -b ign-transport4
   Sdformat: git clone https://github.com/osrf/sdformat -b sdf6
   Gazebo:  git clone https://github.com/osrf/gazebo -b gazebo9


-  Load compiler: Execute below command (Path can be different for each user)

"C:\Program Files\Microsoft Visual Studio\2019\Community\VC\Auxiliary\Build\vcvarsall.bat" x86_amd64  


 - Configure and build Ignition CMake. Post this CMake will be installed in gz-ws/ign-cmake/build/install/Release

cd ign-cmake
.\configure
nmake
nmake install


- Configure and build Ignition Math. Post this Math will be installed gz-ws/ign-math/build/install/Release

cd ign-math
.\configure
nmake
nmake install

- Configure and build Ignition Common. Post this Common will be installed gz-ws/ign-common/build/install/Release.

cd ign-common
.\configure
nmake
nmake install

- Configure and build Ignition Fuel Tools. Post this Fuel Tools will be installed in gz-ws/ign-fuel-tools/build/install/Release.

cd ign-fuel-tools
.\configure
nmake
nmake install

- Configure and build Ignition Msgs. Post this, Ignition Msgs will be installed in gz-ws/ign-msgs/build/install/Release

cd ..\..\ign-msgs
mkdir build
cd build
..\configure
nmake
nmake install
You should now have an installation of 

- Configure and build Ignition Transport. Post this, Ignition Transport will be installed in gz-ws/ign-transport/build/install/Release

cd ..\..\ign-transport
mkdir build
cd build
..\configure
nmake
nmake install


- Configure and build Sdformat. Post this, Sdformat will be installed in gz-ws/sdformat/build/install/Release or gz-ws/sdformat/build/install/Debug.

cd ..\..\sdformat
mkdir build
cd build
..\configure
nmake
nmake install
You should now have an installation of 

- Configure and build Gazebo:

cd ..\..\gazebo
mkdir build
cd build
..\configure
nmake gzclient
nmake gzserver
nmake install

Installation of Gazebo will be in gz-ws/gazebo/build/install/Release or gz-ws/gazebo/build/install/Debug.

-------------------------------------------------------------------------------------------------------------------------------------------- 
Terrain and Levels 

We’ll be making a simple outdoor level that the player can walk through. We’ll be putting various objects that are typical in a video game. We’ll put trees, hills, a campfire, and some music. Basically you’ll go through the things in Unity that are already there. This is so you would know that you don’t need to create source code for these things from scratch anymore. Now go to GameObject > 3D object > Terrain > Create Terrain. You should see a large flat platform appear. This is your terrain
Terrain Tool.

In the Inspector View, you’ll see a new kind of component, the Terrain component. Look at the row of buttons in your Terrain component. These are tools that will help you spice up your ground terrain.

Go ahead and click the leftmost button. This is the Raise/Lower Terrain tool. Now move your mouse cursor to that flat land in the Scene View. You’ll see a blue glow following your mouse. This is your terrain brush. Go ahead and left-click. You’ll see a mound form up. Just imagine as if you are painting, but instead of putting in colors, you’ll be putting in mountains.

Feel free to create mountains in any way you want. If you make a mistake, you can undo it with Ctrl + Z. Further down the terrain component, you’ll see a selection of brush shapes. Go ahead and try them.

Adding Texture 

Our terrain is looking pretty bare with all that gray color. We’ll make use of an image to give better color to our terrain. Now you’ll see the Project View has a new folder called “Standard Assets”. Inside this are a few files that we’ll be using. Click on the fourth button on the terrain tools. This is the Paint Texture tool. Add the grassy hill texture to the albedo component. Now you’ll see that image used on the terrain.

Adding more texture

You can add another “texture” the same way. Choose Rock texture this time. Use 50 for the “Tile Size X” and “Tile Size Y” values. Now go ahead and paint on your mountains. You can add as many new “textures” as you want and paint with them.

Installing the Terrain Editor

First, go to Window -> Package Manager and select Unity Registry in the Packages drop-down menu in the upper left corner. Select the settings gear in the top right, then select Advanced Project Settings. Make sure the Enable Preview Packages option is checked.
Now, in the search box in the upper right corner, enter Terrain Tool. The Install button will appear in the bottom right corner. Press it and wait until the download completes.

Go to Window -> Terrain -> Terrain Toolbox and open it.

Basically, it’s a window containing a toolbar with some buttons on the top.Those four buttons are the main Toolbox tabs.

Unity added a terrain gizmo. Activate it by clicking the checkbox next to Gizmo in the Create New Terrain tab.

With this tool, it’s easy to check the boundaries and overall height of your terrains. It also gives you an intuitive idea of the extension a terrain has. Unfortunately, you can only use it on one terrain at a time.

What’s it good for? For example, say you want to raise your overall terrain height by 50%. The gizmo will clearly show you both positive and negative headroom, like this:

Heightmaps are among the most important and fun tools at your disposal.

Now, go to the Terrain Toolbox. Select the Create New Terrain tab and click the Import Heightmap toggle to activate it.

Terrain Texture:

Do this:

1.	Select the Terrain_1 GameObject.
2.	Go to the Terrain component.
3.	Select the Paint Terrain tab.
4.	In the first dropdown below the row of tabs, select Paint Texture.
5.	Find the Layers section.
6.	Click Add Layer.
7.	Find TextureMountainLayer 1 and select it.

Go to the Terrain Settings tab in the same component and adjust Base Map Distance to maximum.

The Terrain Settings tab on the Toolbox is the same as the Terrain Settings tab on the Terrain component… but you can only apply the former, as you’ve read before, to all terrains.

Terrain Utilities Tab

Welcome to one the most important tools. Terrain Utilities is where the Toolbox really exploits its “one-for-all” power.

As a quick introduction, this tab allows you to safely erase terrains. No more lost terrains cluttering your project. Also, you can manage all your layers and splatmaps from here.

-------------------------------------------------------------------------------------------------------------------------------------------- 


