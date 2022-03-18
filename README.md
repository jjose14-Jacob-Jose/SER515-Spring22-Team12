
# SER515-Spring22-Team12

GitHub repo for SER 515 Spring 22 Team 12.


This repository will have all the artifacts for SER 515 - Group 12, Simulation Rover.

 #### Built With  ####

- Unity 3D - 2023 26f1 
- ROS 2 
- SLAM 
- ODOM 
- Python 
- Rviz 
- Docker

 #### Prerequisites ####

* Generate public key
* Add it into github account
* Open command prompt & execute ssh-keygen
* By default the system will save the keys to C:\Users\your_username/.ssh/id_rsa.
* Navigate to C:\Users\your_username/.ssh folder anc copy id_rsa.pub Add tis key to github account.

* Clone the repo git clone -b master https://github.com/ksharm53/SER515-Spring22-Team12.git


--------------------------------------------------------------------------------------------------------------------------------------------
Authors
--------------------------------------------------------------------------------------------------------------------------------------------

- Jacob Jose
- Kanav Sharma
- Nihal Singh
- Virinchi
- Krishna Pandya
- Jay Patel

--------------------------------------------------------------------------------------------------------------------------------------------
Installation
--------------------------------------------------------------------------------------------------------------------------------------------
#### Install Chocolatey

[Reference URL](https://chocolatey.org/install)

 - Ensure that you are using an administrative shell - you can also install as a non-admin, check out Non-Administrative Installation.
 - Install with powershell.exe
 - Run Get-ExecutionPolicy. If it returns Restricted, then run Set-ExecutionPolicy AllSigned or Set-ExecutionPolicy Bypass -Scope Process.
#### Run the following command:

```bash
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
```

 - Paste the copied text into your shell and press Enter.

 - Wait a few seconds for the command to complete.

 - If you don't see any errors, you are ready to use Chocolatey! Type choco or choco to check version.


 --------------------------------------------------------------------------------------------------------------------------------------------
#### Python

 - Open a Command Prompt and type the following to install Python via Chocolatey:
 - Check whether there are any versions other than 3.8.3 
 - If yes, uninstall python via System control panel.

```bash
choco install -y python --version 3.8.3
```

 - ROS 2 expects the python installation to be available in directory  C:\python38. Double check that it is installed there.

--------------------------------------------------------------------------------------------------------------------------------------------
#### Visual C++ Redistributables

 - Open a Command Prompt and type the following to install them via Chocolatey:

```bash
choco install -y vcredist2013 vcredist140
```

--------------------------------------------------------------------------------------------------------------------------------------------
#### Install OpenSSL

 - Download the Win64 OpenSSL v1.1.1L OpenSSL installer [link]( https://slproweb.com/products/Win32OpenSSL.html ). 
 - Scroll to the bottom of the page and download Win64 OpenSSL v1.1.1L. Don’t download the Win32 or Light versions.
 - Run the installer with default parameters, as the following commands assume you used the default installation directory.
- This command sets an environment variable that persists over sessions:
```bash
< setx -m OPENSSL_CONF "C:\Program Files\OpenSSL-Win64\bin\openssl.cfg" >
```

 - You will also need to append the OpenSSL-Win64 bin folder to your PATH. 
 - You can do this by clicking the Windows icon, typing “Environment Variables”, then clicking on “Edit the system environment variables”. 
 - In the resulting dialog, click “Environment Variables”, then click “Path” on the bottom pane, finally click “Edit” and add the path below.

```bash
< C:\Program Files\OpenSSL-Win64\bin\ >
```
-------------------------------------------------------------------------------------------------------------------------------------------- 

#### Install Visual Studio


 - If you already have a paid version of Visual Studio 2021 (Professional, Enterprise), skip this step.
 - Microsoft provides a free of charge version of Visual Studio 2021, named Community, which can be used to build applications that use ROS 2. 
 - You can download the installer directly through this [link]( https://code.visualstudio.com/updates/v1_64 )
 - Make sure that the Visual C++ features are installed.
 - An easy way to make sure they’re installed is to select the Desktop development with C++ workflow during the install. 
 - Make sure that no C++ CMake tools are installed by unselecting them in the list of components to be installed.   
------------------------------------------------------------------------------------------------------------------------------------------- 

#### Install OpenCV:

Some of the examples require OpenCV to be installed.

 - You can download a precompiled version of OpenCV 3.4.6 from [link](https://github.com/ros2/ros2/releases/download/opencv-archives/opencv-3.4.6-vc16.VS2019.zip).
 - Assuming you unpacked it to C:\opencv, type the following on a Command Prompt (requires Admin privileges):
 - setx -m OpenCV_DIR C:\opencv
 - Since you are using a precompiled ROS version, we have to tell it where to find the OpenCV libraries. You have to extend the PATH variable to C:\opencv\x64\vc16\bin.


--------------------------------------------------------------------------------------------------------------------------------------------
 #### Install Dependencies

You will need to append the CMake bin folder C:\Program Files\CMake\bin to your PATH.

Please download these packages from this GitHub repository.

 - asio.1.12.1.nupkg
 - bullet.2.89.0.nupkg
 - cunit.2.1.3.nupkg
 - eigen-3.3.4.nupkg
 - tinyxml-usestl.2.6.2.nupkg
 - tinyxml2.6.0.0.nupkg
 - log4cxx.0.10.0.nupkg

Once these packages are downloaded, open an administrative shell and execute the following command:
```bash
choco install -y -s <PATH\TO\DOWNLOADS> asio cunit eigen tinyxml-usestl tinyxml2 log4cxx bullet
````
 - Please replace <PATH\TO\DOWNLOADS> with the folder you downloaded the packages to.

You must also install some python dependencies for command-line tools:
```bash
python -m pip install -U catkin_pkg cryptography empy ifcfg lark-parser lxml netifaces numpy opencv-python pyparsi
````
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

Rover Wheels 

Documentation of Wheels:


-	In the project, we will be creating 2-wheeled rover just like Gopigo3 with collider that will make the rover more realistic in terms of physical collisions with objects.


Creating planes for placing rover:

-	Now, to create the sample plane go to GameObject->3D object-> Plane. To make the plane to zero transform click on transform at the right side of the plane and click reset.
We can change the length of the plane in X, Y or Z direction we can change the scale.

Creating base component for rover:

-	To create a base component, we can go to GameObject -> Create Empty and change the name of component to rover.

-	To use wheel colliders, we must have a Rigidbody attached to the root which is rover. We can add it by clicking to rover and then add a component Rigidbody to it. 

-	We can change properties like Mass, drag, angular drag in Rigidbody.

-	To create a car body part, we can take cube as parent box under rover.


Adding the mesh renderer component in wheels:
-	Mesh in unity gives idea of the structure of vertex positions, and how they will be displayed on the screen.
-	Mesh renderer is used to render the mesh. To take mesh from the asset and pass it to mesh renderer ‘Mesh Filter’ component is used.
-	We can give the number of materials to be used in mesh renderer and the elements/materials.
-	Lighting defines the shadows and illumination. For example, to specify how shadows are casted when a light is shined on renderer, Cast Shadows property is used.
-	While designing on wheels, mesh renderer will be used to display wheels with different visual layers. 



Implementing the wheels collider for rover:

-	To add the script for wheel collider, under rover click add component-> New script. 
-	Now we can create a class and the properties of the class like the following way:

public class WheelInfo
{
	public WheelCollider wheelcollider;
	public Transform visualwheel;
}

-	To change the steering angle of the wheel, we can use the steerAngle property. i.e.,

public WheelInfo wheel1; //creating variable wheel1 of class wheelInfo

wheel1.wheelcollider.steerAngle = a * b; //a and b can be any variables  	

-	Similar to steerAngle, to change the motor torque and torque of brake, motorTorque and brakeTorque properties are used respectively.
i.e., wheel1.wheelcollider.motorTorque and wheel1.wheelcollider.brakeTorque
 
-	To find the whether the child with given name is present under gameobject, GetChild method is used. 

For example, 
		gameobject.transform.getChild(index).name


Creating wheels component for rover:

-	To create wheels component add an empty child to rover and name it to wheels. Reset its transform and create empty child under wheels.
-	Change the name of the child to left and set the position of it according to the size. For example, (-1,0,1). Add wheel collider component to that wheel.
-	Duplicate the left wheel copy it under wheels and rename it to right wheels. Change the position of X for right wheel.
i.e., (1,0,1). And the wheels will be shown in the model.


References:

i)	https://www.diva-portal.org/smash/get/diva2:1334348/FULLTEXT01.pdf

ii)	https://docs.unity3d.com/Manual/WheelColliderTutorial.html

iii)	https://www.theconstructsim.com/ros-projects-exploring-ros-using-2-wheeled-robot-part-1/

-------------------------------------------------------------------------------------------------------------------------------------------- 
 
 Maze

 Documentation for maze:


A maze is a collection or areas linked together such that you can start anywhere and from there be able visit every other area. The shape and layout of these areas and how exactly they are connected defines the character of the maze.

For Maze:
-There are several ways of designing maze in unity.
Basic :
-For creating maze, we need to first create a plane.
-After creating plane, we need to first put walls.
-A wall is a 3D object, so add cube and gives it a shape of wall by adjusting its coordinates.
-Similarly create other duplicate walls and decide their sizes. After this put each wall adjacently in a way that they form a maze-like structure.
Reference: https://www.youtube.com/watch?v=L8sfSBLBRGY
		https://catlikecoding.com/unity/tutorials/maze/

Using Algorithm:
The other way of creating a maze is using a maze generation algorithm. Recursive Backtracking is one such algorithm.
Here’s the mile-high view of recursive backtracking:
1.	Choose a starting point in the field.
2.	Randomly choose a wall at that point and carve a passage through to the adjacent cell, but only if the adjacent cell has not been visited yet. This becomes the new current cell.
3.	If all adjacent cells have been visited, back up to the last cell that has uncarved walls and repeat.
4.	The algorithm ends when the process has backed all the way up to the starting point.

Reference : http://weblog.jamisbuck.org/2010/12/27/maze-generation-recursive-backtracking

-Another method for creating maze uses unity terrain tool.
Reference: https://www.youtube.com/watch?v=S8XVGMDZM8U 

However, the most relevant method for designing maze in our project is the basic one mentioned above.

-------------------------------------------------------------------------------------------------------
------------------------------------------------------------------

Rover Structure Creation and Movement:

C# Scripts:
The behavior of GameObjects is controlled by the Components that are attached to them. Although Unity’s built-in Components can be very versatile, you will soon find you need to go beyond what they can provide to implement your own gameplay features. Unity allows you to create your own Components using scripts. These allow you to trigger game events, modify Component properties over time and respond to user input in any way you like.

Unity supports the C# programming language natively. C# (pronounced C-sharp) is an industry-standard language similar to Java or C++.

In addition to this, many other .NET languages can be used with Unity if they can compile a compatible DLL

Creating Script:
Unlike most other assets, scripts are usually created within Unity directly. You can create a new script from the Create menu at the top left of the Project panel or by selecting Assets > Create > C# Script from the main menu.

The new script will be created in whichever folder you have selected in the Project panel. The new script file’s name will be selected, prompting you to enter a new name.

Box Collider:
The Box Collider is a basic cuboid-shaped collision primitive.

Property:Function
Is Trigger: If enabled,this Collider is used for triggering events, and is ignored by the physics engine
Material: Reference to the Physics Material that determines how this Collider interacts with others.
Center: The position of the Collider in the object’s local space.
Size: The size of the Collider in the X, Y, Z directions.

Details:
Box Colliders are rectangular cuboids and are useful for items such as crates or chests. However, you can use a thin box as a floor, wall or ramp. The Box Collider is also a useful element in a Compound Collider.

To edit the box’s shape, press the Edit Collider button in the Inspector,To exit the Collider Edit Mode press the Edit Collider button again. A vertex appears in the center of each face of the Box Collider in Edit Mode. To move the vertices, drag them when the mouse is over the vertex to make the Box Collider bigger and smaller.

Wheel Colider:
The Wheel Collider is a special collider for grounded vehicles. It has built-in collision,detection, wheel physics, and a slip-based tire friction model. It can be used for objects other than wheels, but it is specifically designed for vehicles with wheels.


Rover Structure Creation and Movement:

This are the steps:

[1] - Create a new Project

[2] - Add a terrain

[3] - Import some Assets
The assets to import are the environment elements and the SmoothFollow script.

[4] - Model the terrain
Now lets model the terrain creating some mountains, applying textures, like grass and drawing the path.

[5] - Add a empty game object
This gameObject will be used as a container for the rover.

[6] - Add a cube.
Add a cube to the rover gameObject. Change the position of the cube for 0,0,0.
Change the position of the gameObject rover so it stands inside the terrain.
If you like you can add other cubes so the rover looks better. Add the cubes always as a child of the gameObject rover.
Remover the cubes box colliders and add a rigidbody and a box collider to the gameObject rover.
Change the box collider size so it matches the body of the rover.

[7] - Add a cylinder
The cylinder will be used to make the wheels. First we build one then its just copy and paste.
Positioned the cylinder near the body of the rover, change the size and rotate it.
It should look something like this.

[8] - Remove the collider and add a wheelcollider
Now that the wheel is in place remove the capsule collider and add a wheelcollider.
This component is responsible for the calculations that will make the rover physics seam real.
Last, but not least, make the wheel a child of the rover.
If you test the rover, executing the scene, it will jump and the camera won't show the rover.
First the camera, add the smoothfollow to it and define the target to be the rover. The distance should be 2.
As for the rover it should have a mass of 1000, change it in the rigidbody.
There it is. Just one wheel though.

[9] - Copy and paste the Wheel
At this point we should copy and past this wheel and position each in the corners of the rover.
Each wheel should have a name according to the position.
To make it possible to see the wheels spin we will add a material that looks like a rim.
Next make a material with the texture and add the material to each wheel. It ain't pretty but its effective.

[10] - Add a new C# script
This script will control the behavior of the rover.
This script should define an array for the wheels, the power of the motor and the max rotation angle of the side wheels.
Drag the script to the rover gameObject and then drag each wheel to the array.
Let's declare some private variables.
And a function to simplify the code that needs to access the wheelcolliders.
Next we need to read the user input and rotate the wheels colliders and the wheels
After that the wheels should spin.
In the end let's add the brakes and the engine.


-------------------------------------------------------------------------------------------------------
------------------------------------------------------------------


Testing Of Wheels:

-I have done testing of the wheels implemented in Unity 3D by Krishna, which was one of my task(#136) under US #107.
- I first imported the work done by Krishna of wheels in my device and ran the project in Unity 3D.

-I ran the project and I pointed out the following things:
-> Friction is less. Wheels are moving by its own when it is at some elevation or suddenly is stopped. This need to be improved.
->Sudden stop is not working well. It needs to be optimized and the wheels should stop properly when it is required to do suddenly.
-> Rover is moving by its own when it is on slope of terrain. So that need to be balanced by setting the friction property properly.
-> The Jump feature can be added to the wheels. This feature is not currently added but this might be helpful to tackle obstacles. It can be adjusted in future as per the need when the wheels are integrated with the original rover body.
->Wheel colliders are working perfectly. The sample body implemented here is moving perfectly with the support of wheels.
-> Body controlling through keyboard inputs is going smoothly. Wheels are moving without any failure and as per the requirement.
->Rover is running well on terrain fields. The terrain made here is just sample to demonstrate the rover movement and the wheels are working well on it without any issues. 
-> One important thing is that the wheels need to be connected with the chassis when it is integrated with the rover body. Here a gap can be seen between wheels and rover body but it is ok for now as this is just demonstration of working of wheels which is implemented correctly.
-> Currently the wheels are moving according to the inputs given from the keyboard. This have to be made autonomous when integrated with the original body. 
-> The controlling of the wheels needs to be improved.

  Conclusively, the wheels are working well as of now with improvements required in the setting the friction property. And the jump feature needs to be added in the wheels.

Things accomplished after testing:

In the testing of wheels, as a part of my task I have mentioned the things that has to be done. Some of the things that are required features in the project need to be implemented.
Some examples of the tasks which need to be done are:
-Adjusting the friction properly.
-Adding the jump feature to the wheels.
-Chassis for wheels has to be implemented.
-Controlling of wheels need to be improved.
These requirements are now fulfilled, and the work has been finished.
The work done regarding these tasks is stated below:
->The Jump feature is now added for the wheels. A new task namely Implementation of jump in wheels was done. I implemented jump by creating a new project in unity and creating a dummy object. This object was assigned as a rigid body and was enabled with the jump. Some obstacles were also created and the object was able to do jump over them. This feature then to be integrated with the wheels. It might be needed that this feature to be modified for the final integration of various components and can be updated accordingly.

-> The next feature is the friction of wheels. Friction has to be adjusted so that the wheels do not slide on sudden stoppage. Earlier when wheels were stopped all of a sudden, they used to move some distance before stopping completely. But now this property is been perfectly modified and now the rover wheels stops as required.

->Chassis is an important feature which has to implement so that the rover wheels can be connected with the body without showing any gap. Earlier some gap was there between wheels and body and to eliminate this gap and for proper connection, chassis has to be implemented. Chassis are now implemented by Krishna and now properly installed. The code regarding this is also pushed using a commit on github.

->The controlling of the wheels is now improved considerably. Adjusting some properties like its friction, suspension and mass(according to gravity) has helped in improving it.

-> Making rover wheels move without keyboard inputs will be done in later sprints.

