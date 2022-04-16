
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

#### Install Qt5:

This section is only required if you are building rviz.

- First get the installer from Qt’s [website](https://www.qt.io/download).
- Select the Open Source version and then the Qt Online Installer for Windows.
- Run the installer and install Qt5.

We recommend you install it to the default location of C:\Qt, but if you choose somewhere else, make sure to update the paths below accordingly. When selecting components to install, the only thing you absolutely need is the appropriate MSVC 64-bit component under the Qt -> Qt 5.15.0 tree. We’re using 5.15.0 as of the writing of this document and that’s what we recommend since that’s all we test on Windows, but later Qt5 versions will probably work too. Be sure to select MSVC 2019 64-bit. After that, the default settings are fine.

 - Finally, set the Qt5_DIR environment variable in the cmd.exe where you intend to build so that CMake can find it:
```bash
set Qt5_DIR=C:\Qt\5.15.0\msvc2019_64
set QT_QPA_PLATFORM_PLUGIN_PATH=C:\Qt\5.15.0\msvc2019_64\plugins\platforms
````
- You could set it permanently with below instead. Use Admin access for the same.
```bash
setx -m Qt5_DIR C:\Qt\5.15.0\msvc2019_64 
setx -m QT_QPA_PLATFORM_PLUGIN_PATH C:\Qt\5.15.0\msvc2019_64\plugins\platforms 
````
-------------------------------------------------------------------------------------------------------------------------------------------- 
#### RQT Dependencies

- Open Command Prompt with administrative privileges and run the following commands. 
```bash
python -m pip install -U pydot PyQt5
choco install graphviz
````
- Then a directory will be created at the location 'C:\Program Files\Graphviz\bin.
- Add the 'bin' of this directory (Graphviz) to your environmental variables PATH.

-------------------------------------------------------------------------------------------------------------------------------------------- 
#### Downloading ROS2

- [Go to](https://github.com/ros2/ros2/releases) and download the latest package for Windows.
- It should have a name like 'ros2-foxy-*-windows-AMD64.zip'. 
- Here, you can click on the [URL](https://github.com/ros2/ros2/releases/download/release-foxy-20220208/ros2-foxy-20220208-windows-release-amd64.zip) to download ROS 2 Foxy.
- Unpack the zip file to the directory "C:\dev\ros2_foxy"

-------------------------------------------------------------------------------------------------------------------------------------------- 
#### Environment Setup

- Start a command shell and source the ROS 2 setup file to set up the workspace:
```bash
call C:\dev\ros2_foxy\local_setup.bat
````
- It is normal that the previous command, if nothing else went wrong, outputs “The system cannot find the path specified.” exactly once.

-------------------------------------------------------------------------------------------------------------------------------------------- 

#### Examples

In a command shell, set up the ROS 2 environment as described and then run a C++ talker:
```bash
ros2 run demo_nodes_cpp talker
```
- Start another command shell and run a Python listener:
```bash
ros2 run demo_nodes_py listener
```
-------------------------------------------------------------------------------------------------------------------------------------------- 

#### Gazebo (Windows)
 - Prerequisites: 30Gb free disk space
 
Installation:

- Create directory in the root
```bash
  mkdir gz-ws
  cd gz-ws
```
- Download all below dependencies and extract into folder created previously
   - [Curl](https://s3.amazonaws.com/osrf-distributions/win32/deps/curl-7.57.0-vc15-x64-dll-MD.zip).
   - [LibYaml](https://s3.amazonaws.com/osrf-distributions/win32/deps/libyaml-0.1.7-vc15-x64-md.zip).
   - [dlfcn](https://s3.amazonaws.com/osrf-distributions/win32/deps/dlfcn-win32-vc15-x64-dll-MD.zip).
   - [jsoncpp](https://s3.amazonaws.com/osrf-distributions/win32/deps/jsoncpp-1.8.4-vc15-x64-dll-MD.zip).  
   - [protobuf](https://s3.amazonaws.com/osrf-distributions/win32/deps/protobuf-3.4.1-vc15-x64-dll-MD.zip).
   - [libzip](https://s3.amazonaws.com/osrf-distributions/win32/deps/libzip-1.4.0_zlip-1.2.11_vc15-x64-dll-MD.zip).
   - [zzip](https://s3.amazonaws.com/osrf-distributions/win32/deps/zziplib-0.13.62-vc12-x64-release-debug.zip).
   - [FreeImage](https://s3.amazonaws.com/osrf-distributions/win32/deps/FreeImage3180Win32Win64.zip).
   - [boost](https://s3.amazonaws.com/osrf-distributions/win32/deps/boost_1_67_0.zip).
   - [ogre](https://s3.amazonaws.com/osrf-distributions/win32/deps/ogre-sdk-1.10.12-vc15-x64.zip).
   - [bzip](https://s3.amazonaws.com/osrf-distributions/win32/deps/bzip2-1.0.6-vc12-x64-release-debug.zip).
   - [tbb](https://s3.amazonaws.com/osrf-distributions/win32/deps/tbb43_20141023oss_win.zip).
   - [qt](https://s3.amazonaws.com/osrf-distributions/win32/deps/qt-opensource-windows-x86-msvc2015_64-5.7.0.zip).
   - [qwt](https://s3.amazonaws.com/osrf-distributions/win32/deps/qwt_6.1.2~osrf_qt5.zip).
   - [libzmq](https://s3.amazonaws.com/osrf-distributions/win32/deps/libzmq-4.2.3_cppzmq-4.2.2_vc15-x64-dll-MD.zip).
 

- Install CMake and add it into the path. [Link to download](http://www.cmake.org/download/).
- Install Ruby and add it into system path.[Link to download](http://rubyinstaller.org/downloads/).  
- Clone below into folder created
   - CMake  : ```bash git clone https://github.com/ignitionrobotics/ign-cmake -b ign-cmake0 ```
   - Common : ```bash git clone https://github.com/ignitionrobotics/ign-common -b ign-common1 ```
   - Fuel Tools  : ```bash git clone https://github.com/ignitionrobotics/ign-fuel-tools -b ign-fuel-tools1 ```
   - Math : ```bash git clone https://github.com/ignitionrobotics/ign-math -b ign-math4 ```
   - Ignition Msgs : ```bash git clone https://github.com/ignitionrobotics/ign-msgs -b ign-msgs1 ```
   - Transport :```bash git clone https://github.com/ignitionrobotics/ign-transport -b ign-transport4 ```
   - Sdformat: ```bash git clone https://github.com/osrf/sdformat -b sdf6 ```
   - Gazebo:  ```bash git clone https://github.com/osrf/gazebo -b gazebo9 ```


-  Load compiler: Execute below command (Path can be different for each user)
```bash
"C:\Program Files\Microsoft Visual Studio\2019\Community\VC\Auxiliary\Build\vcvarsall.bat" x86_amd64  
```

 - Configure and build Ignition CMake. Post this CMake will be installed in gz-ws/ign-cmake/build/install/Release

```bash
cd ign-cmake
.\configure
nmake
nmake install
```

- Configure and build Ignition Math. Post this Math will be installed gz-ws/ign-math/build/install/Release
```bash
cd ign-math
.\configure
nmake
nmake install
```
- Configure and build Ignition Common. Post this Common will be installed gz-ws/ign-common/build/install/Release.
```bash
cd ign-common
.\configure
nmake
nmake install
```
- Configure and build Ignition Fuel Tools. Post this Fuel Tools will be installed in gz-ws/ign-fuel-tools/build/install/Release.
```bash
cd ign-fuel-tools
.\configure
nmake
nmake install
```
- Configure and build Ignition Msgs. Post this, Ignition Msgs will be installed in gz-ws/ign-msgs/build/install/Release
```bash
cd ..\..\ign-msgs
mkdir build
cd build
..\configure
nmake
nmake install
```


- Configure and build Ignition Transport. Post this, Ignition Transport will be installed in gz-ws/ign-transport/build/install/Release
```bash
cd ..\..\ign-transport
mkdir build
cd build
..\configure
nmake
nmake install
```

- Configure and build Sdformat. Post this, Sdformat will be installed in gz-ws/sdformat/build/install/Release or gz-ws/sdformat/build/install/Debug.
```bash
cd ..\..\sdformat
mkdir build
cd build
..\configure
nmake
nmake install
```
You should now have an installation of 

- Configure and build Gazebo:

```bash
cd ..\..\gazebo
mkdir build
cd build
..\configure
nmake gzclient
nmake gzserver
nmake install
```
 - Installation of Gazebo will be in gz-ws/gazebo/build/install/Release or gz-ws/gazebo/build/install/Debug.

-------------------------------------------------------------------------------------------------------------------------------------------- 

#### Terrain and Levels 

We’ll be making a simple outdoor level that the player can walk through. We’ll be putting various objects that are typical in a video game. We’ll put trees, hills, a campfire, and some music. Basically you’ll go through the things in Unity that are already there. This is so you would know that you don’t need to create source code for these things from scratch anymore. Now go to GameObject > 3D object > Terrain > Create Terrain. You should see a large flat platform appear. This is your terrain
Terrain Tool.

In the Inspector View, you’ll see a new kind of component, the Terrain component. Look at the row of buttons in your Terrain component. These are tools that will help you spice up your ground terrain.

Go ahead and click the leftmost button. This is the Raise/Lower Terrain tool. Now move your mouse cursor to that flat land in the Scene View. You’ll see a blue glow following your mouse. This is your terrain brush. Go ahead and left-click. You’ll see a mound form up. Just imagine as if you are painting, but instead of putting in colors, you’ll be putting in mountains.

Feel free to create mountains in any way you want. If you make a mistake, you can undo it with Ctrl + Z. Further down the terrain component, you’ll see a selection of brush shapes. Go ahead and try them.

 - Adding Texture 

Our terrain is looking pretty bare with all that gray color. We’ll make use of an image to give better color to our terrain. Now you’ll see the Project View has a new folder called “Standard Assets”. Inside this are a few files that we’ll be using. Click on the fourth button on the terrain tools. This is the Paint Texture tool. Add the grassy hill texture to the albedo component. Now you’ll see that image used on the terrain.

 - Adding more texture

You can add another “texture” the same way. Choose Rock texture this time. Use 50 for the “Tile Size X” and “Tile Size Y” values. Now go ahead and paint on your mountains. You can add as many new “textures” as you want and paint with them.

 - Installing the Terrain Editor

    - Go to Window -> Package Manager and select Unity Registry in the Packages drop-down menu in the upper left corner. Select the settings gear in the top right, then select Advanced Project Settings. Make sure the Enable Preview Packages option is checked.
    - In the search box in the upper right corner, enter Terrain Tool. The Install button will appear in the bottom right corner. Press it and wait until the download completes.
    - Go to Window -> Terrain -> Terrain Toolbox and open it.

Basically, it’s a window containing a toolbar with some buttons on the top.Those four buttons are the main Toolbox tabs.

Unity added a terrain gizmo. Activate it by clicking the checkbox next to Gizmo in the Create New Terrain tab.

With this tool, it’s easy to check the boundaries and overall height of your terrains. It also gives you an intuitive idea of the extension a terrain has. Unfortunately, you can only use it on one terrain at a time.

What’s it good for? For example, say you want to raise your overall terrain height by 50%. The gizmo will clearly show you both positive and negative headroom, like this:

Heightmaps are among the most important and fun tools at your disposal.

Now, go to the Terrain Toolbox. Select the Create New Terrain tab and click the Import Heightmap toggle to activate it.

 - Terrain Texture:

Do this:

    - Select the Terrain_1 GameObject.
    - Go to the Terrain component.
    - Select the Paint Terrain tab.
    - In the first dropdown below the row of tabs, select Paint Texture.
    - Find the Layers section.
    - Click Add Layer.
    - Find TextureMountainLayer 1 and select it.

Go to the Terrain Settings tab in the same component and adjust Base Map Distance to maximum.

The Terrain Settings tab on the Toolbox is the same as the Terrain Settings tab on the Terrain component… but you can only apply the former, as you’ve read before, to all terrains.

Terrain Utilities Tab

Welcome to one the most important tools. Terrain Utilities is where the Toolbox really exploits its “one-for-all” power.

As a quick introduction, this tab allows you to safely erase terrains. No more lost terrains cluttering your project. Also, you can manage all your layers and splatmaps from here.

-------------------------------------------------------------------------------------------------------------------------------------------- 

#### Rover Wheels 

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

```bash
public class WheelInfo
{
	public WheelCollider wheelcollider;
	public Transform visualwheel;
}
```
-	To change the steering angle of the wheel, we can use the steerAngle property. i.e.,

```bash
public WheelInfo wheel1; //creating variable wheel1 of class wheelInfo

wheel1.wheelcollider.steerAngle = a * b; //a and b can be any variables  	
```
-	Similar to steerAngle, to change the motor torque and torque of brake, motorTorque and brakeTorque properties are used respectively.
```bash
i.e., wheel1.wheelcollider.motorTorque and wheel1.wheelcollider.brakeTorque
``` 
-	To find the whether the child with given name is present under gameobject, GetChild method is used. 

```bash
For example, 
		gameobject.transform.getChild(index).name
```

Creating wheels component for rover:

-	To create wheels component add an empty child to rover and name it to wheels. Reset its transform and create empty child under wheels.
-	Change the name of the child to left and set the position of it according to the size. For example, (-1,0,1). Add wheel collider component to that wheel.
-	Duplicate the left wheel copy it under wheels and rename it to right wheels. Change the position of X for right wheel.
i.e., (1,0,1). And the wheels will be shown in the model.


#### References

- https://www.diva-portal.org/smash/get/diva2:1334348/FULLTEXT01.pdf

- https://docs.unity3d.com/Manual/WheelColliderTutorial.html

- https://www.theconstructsim.com/ros-projects-exploring-ros-using-2-wheeled-robot-part-1/

-------------------------------------------------------------------------------------------------------------------------------------------- 
 
 #### Maze

A maze is a collection or areas linked together such that you can start anywhere and from there be able visit every other area. The shape and layout of these areas and how exactly they are connected defines the character of the maze.

There are several ways of designing maze in unity.
- Basic :
  - For creating maze, we need to first create a plane.
  - After creating plane, we need to first put walls.
  - A wall is a 3D object, so add cube and gives it a shape of wall by adjusting its coordinates.
  - Similarly create other duplicate walls and decide their sizes. After this put each wall adjacently in a way that they form a maze-like structure.
  - [Reference](https://www.youtube.com/watch?v=L8sfSBLBRGY).
  - [Reference](https://catlikecoding.com/unity/tutorials/maze/).

 - Using Algorithm:

The other way of creating a maze is using a maze generation algorithm. Recursive Backtracking is one such algorithm.
Here’s the mile-high view of recursive backtracking:

  - Choose a starting point in the field.
  - Randomly choose a wall at that point and carve a passage through to the adjacent cell, but only if the adjacent cell has not been visited yet. This becomes the new current cell.
  - If all adjacent cells have been visited, back up to the last cell that has uncarved walls and repeat.
  - The algorithm ends when the process has backed all the way up to the starting point.
  - [Reference](http://weblog.jamisbuck.org/2010/12/27/maze-generation-recursive-backtracking).

Another method for creating maze uses unity terrain tool.
[Reference](https://www.youtube.com/watch?v=S8XVGMDZM8U). 

However, the most relevant method for designing maze in our project is the basic one mentioned above.

-------------------------------------------------------------------------------------------------------

#### Rover Structure Creation and Movement:

- C# Scripts:
The behavior of GameObjects is controlled by the Components that are attached to them. Although Unity’s built-in Components can be very versatile, you will soon find you need to go beyond what they can provide to implement your own gameplay features. Unity allows you to create your own Components using scripts. These allow you to trigger game events, modify Component properties over time and respond to user input in any way you like.

Unity supports the C# programming language natively. C# (pronounced C-sharp) is an industry-standard language similar to Java or C++.

In addition to this, many other .NET languages can be used with Unity if they can compile a compatible DLL

- Creating Script:
Unlike most other assets, scripts are usually created within Unity directly. You can create a new script from the Create menu at the top left of the Project panel or by selecting Assets > Create > C# Script from the main menu.

The new script will be created in whichever folder you have selected in the Project panel. The new script file’s name will be selected, prompting you to enter a new name.

- Box Collider:
The Box Collider is a basic cuboid-shaped collision primitive.

- Property:Function
Is Trigger: If enabled,this Collider is used for triggering events, and is ignored by the physics engine
Material: Reference to the Physics Material that determines how this Collider interacts with others.
Center: The position of the Collider in the object’s local space.
Size: The size of the Collider in the X, Y, Z directions.

- Details:
Box Colliders are rectangular cuboids and are useful for items such as crates or chests. However, you can use a thin box as a floor, wall or ramp. The Box Collider is also a useful element in a Compound Collider.

To edit the box’s shape, press the Edit Collider button in the Inspector,To exit the Collider Edit Mode press the Edit Collider button again. A vertex appears in the center of each face of the Box Collider in Edit Mode. To move the vertices, drag them when the mouse is over the vertex to make the Box Collider bigger and smaller.

- Wheel Colider:
The Wheel Collider is a special collider for grounded vehicles. It has built-in collision,detection, wheel physics, and a slip-based tire friction model. It can be used for objects other than wheels, but it is specifically designed for vehicles with wheels.


- Rover Structure Creation and Movement:

   - Create a new Project
   - Add a terrain
   - Import some Assets
The assets to import are the environment elements and the SmoothFollow script.
   - Model the terrain
Now lets model the terrain creating some mountains, applying textures, like grass and drawing the path.
   - Add a empty game object
This gameObject will be used as a container for the rover.
   - Add a cube.
Add a cube to the rover gameObject. Change the position of the cube for 0,0,0.
Change the position of the gameObject rover so it stands inside the terrain.
If you like you can add other cubes so the rover looks better. Add the cubes always as a child of the gameObject rover.
Remover the cubes box colliders and add a rigidbody and a box collider to the gameObject rover.
Change the box collider size so it matches the body of the rover.
   - Add a cylinder
The cylinder will be used to make the wheels. First we build one then its just copy and paste.
Positioned the cylinder near the body of the rover, change the size and rotate it.
It should look something like this.
   - Remove the collider and add a wheelcollider
Now that the wheel is in place remove the capsule collider and add a wheelcollider.
This component is responsible for the calculations that will make the rover physics seam real.
Last, but not least, make the wheel a child of the rover.
If you test the rover, executing the scene, it will jump and the camera won't show the rover.
First the camera, add the smoothfollow to it and define the target to be the rover. The distance should be 2.
As for the rover it should have a mass of 1000, change it in the rigidbody.
There it is. Just one wheel though.
   - Copy and paste the Wheel
At this point we should copy and past this wheel and position each in the corners of the rover.
Each wheel should have a name according to the position.
To make it possible to see the wheels spin we will add a material that looks like a rim.
Next make a material with the texture and add the material to each wheel. It ain't pretty but its effective.
   - Add a new C# script
This script will control the behavior of the rover.
This script should define an array for the wheels, the power of the motor and the max rotation angle of the side wheels.
Drag the script to the rover gameObject and then drag each wheel to the array.
Let's declare some private variables.
And a function to simplify the code that needs to access the wheelcolliders.
Next we need to read the user input and rotate the wheels colliders and the wheels
After that the wheels should spin.
In the end let's add the brakes and the engine.


-------------------------------------------------------------------------------------------------------

#### Testing Of Wheels:

- Testing of the wheels implemented in Unity 3D, task(#136) under US #107.
- Imported the work done by Krishna of wheels in my device and ran the project in Unity 3D.

- Below are the findings:

  - Friction is less. Wheels are moving by its own when it is at some elevation or suddenly is stopped. This need to be improved.
  - Sudden stop is not working well. It needs to be optimized and the wheels should stop properly when it is required to do suddenly.
  - Rover is moving by its own when it is on slope of terrain. So that need to be balanced by setting the friction property properly.
  - The Jump feature can be added to the wheels. This feature is not currently added but this might be helpful to tackle obstacles. It can be adjusted in future as per the need when the wheels are integrated with the original rover body.
  - Wheel colliders are working perfectly. The sample body implemented here is moving perfectly with the support of wheels.
  - Body controlling through keyboard inputs is going smoothly. Wheels are moving without any failure and as per the requirement.
  - Rover is running well on terrain fields. The terrain made here is just sample to demonstrate the rover movement and the wheels are working well on it without any issues. 
  - One important thing is that the wheels need to be connected with the chassis when it is integrated with the rover body. Here a gap can be seen between wheels and rover body but it is ok for now as this is just demonstration of working of wheels which is implemented correctly.
  - Currently the wheels are moving according to the inputs given from the keyboard. This have to be made autonomous when integrated with the original body. 
  - The controlling of the wheels needs to be improved.

Post testing:

In the testing of wheels, as a part of my task I have mentioned the things that has to be done. Some of the things that are required features in the project need to be implemented.
Some examples of the tasks which need to be done are:
- Adjusting the friction properly.
- Adding the jump feature to the wheels.
- Chassis for wheels has to be implemented.
- Controlling of wheels need to be improved.

These requirements are now fulfilled, and the work has been finished.
The work done regarding these tasks is stated below:

- The Jump feature is now added for the wheels. A new task namely Implementation of jump in wheels was done. I implemented jump by creating a new project in unity and creating a dummy object. This object was assigned as a rigid body and was enabled with the jump. Some obstacles were also created and the object was able to do jump over them. This feature then to be integrated with the wheels. It might be needed that this feature to be modified for the final integration of various components and can be updated accordingly.
- The next feature is the friction of wheels. Friction has to be adjusted so that the wheels do not slide on sudden stoppage. Earlier when wheels were stopped all of a sudden, they used to move some distance before stopping completely. But now this property is been perfectly modified and now the rover wheels stops as required.
- Chassis is an important feature which has to implement so that the rover wheels can be connected with the body without showing any gap. Earlier some gap was there between wheels and body and to eliminate this gap and for proper connection, chassis has to be implemented. Chassis are now implemented by Krishna and now properly installed. The code regarding this is also pushed using a commit on github.
- The controlling of the wheels is now improved considerably. Adjusting some properties like its friction, suspension and mass(according to gravity) has helped in improving it.
- Making rover wheels move without keyboard inputs will be done in later sprints.


--------------------------------------------------------------------------------------------------------------------

#### Warehousing and Visualizations:


Adding Visualizations

The Visualizations Package contains a DefaultVisualizationSuite prefab that provides visualizer components for many common ROS message types, organized in the hierarchy by package. These components control how messages are displayed in the Unity scene.

1)If Unity is still in Play mode, exit Play mode.
2)To add the default visualization suite, in the Project window, expand and select Packages/Robotics Visualization. Select the DefaultVisualizationSuite (indicated by the blue cube Prefab icon) and drag it into your scene Hierarchy.

Goal Pose Visualization
If your previous navigation ROS nodes are still running, shut them down. Instead, run the visualization-focused launch file provided:
ros2 launch unity_slam_example unity_viz_example.py
In Unity, enter Play mode. Select the Topics tab in the HUD.
Click into the search bar, and begin typing /goal_pose. When it appears, select the /goal_pose topic name to toggle both the 2D and 3D options. Alternatively, you can select each individual toggle. 2D toggles a GUI window that displays a text-formatted version of the message. 3D toggles the 3D drawing.
You should now see a new window labeled with the /goal_pose topic in your Game view, saying "Waiting for message..."
You can click and drag the edges of the UI to adjust the size and placement of the topic's window.
Open a new terminal in your ROS workspace and begin publishing goal poses,
e.g.:
ros2 topic pub -1 /goal_pose geometry_msgs/PoseStamped "{header: {stamp: {sec: 0}, frame_id: 'map'}, pose: {position: {x: 0.0, y: -4.0, z: 0.0}, orientation: {w: 1.0}}}"

Map Visualization
Next, we'll visualize the map being made.
In Unity, select the Topics tab in the HUD to open the list again. Type /map in the search bar, then select the 3D toggle next to the /map topic name to toggle on the 3D drawing.
The map should now be appearing in the scene as the /map topic receives updates from ROS!

Add Global Costmap Visualization

Laser Scan Visualization

Finally, let's visit how the laser scan sensor is being visualized in the scene. Using the Visualizations Package, point cloud-type visualizations are highly customizable. This section will walk through customization options for a sensor_msgs/LaserScan visualization for your Nav2 project.
1)If you are still in Play mode, exit it.
2)In the scene Hierarchy, once again expand the DefaultVisualizationSuite. This time, expand the sensor_msgs object and select LaserScan to open its Inspector.

In the Topic field, enter /scan.
3)For messages with stamped headers, we need to specify how we want the visualizations to be drawn with respect to the TF tree. This is done via the TF Tracking Settings; click it to expand the options.
4)Enter Play mode. Open the HUD's Topics tab again, and click 3D toggle for /scan. The laser scan message should now be drawing and updating!
5)In the Inspector, select the dropdown for Color Mode. These settings select what value corresponds to the point's colors--distance from the sensor, intensity of the reading, or angle of the reading. Change the value between Distance and Angle and see how the point colors change.
You can also modify the Point Radius to change the size of each drawn point.

--------------------------------------------------------------------------------------------------------------------

### Set up the Environment:

Configuring the ROS settings:
Use the Robotics drop-down menu to open the ROS Settings menu.

In the ROS Settings panel:

1)Ensure the Connect on Startup checkbox is checked
2)Ensure Protocol is set to ROS2
3)For those using a Docker container on the same machine as per our guidance from the setup instructions, leave your ROS IP Address as the default: 127.0.0.1.
Otherwise, set your ROS IP Address to the address of the adapter your ROS2 environment is using.
4)Ensure the Show HUD is checked. This is to ensure you get visual feedback on the state of your ROS connection during runtime.

Starting RViz in docker container:

In a terminal on your host OS, run the following:

  docker run -it --rm -p 6080:80 -p 10000:10000 --shm-size=1024m unity-robotics:nav2-slam-example

In a web browser connect to http://127.0.0.1:6080 and follow the steps below:

1)Click on the bottom left system menu and select System Tools > LXTerminal
2)In the Terminal run:
ros2 launch unity_project example.py
You may also see the following message being spammed in the console:
[controller_server-4] [INFO] [1626978106.918019100] [local_costmap.local_costmap]: Timed out waiting for transform from base_link to odom to become available, tf error: Invalid frame ID "base_link" passed to canTransform argument source_frame - frame does not exist

Launching ROS2 components manually

If you are managing your own ROS2 environment, you can launch the example manually by using:
ros2 launch unity_slam unity_slam.py
If this doesn't work, you may need to first colcon build the workspace or source install/local_setup.bash to properly populate your ROS2 paths.

Starting Unity Simulation:
With the SimpleWareHouseScene open, simply press the Play button at the top of the Editor.

If the ROS2 nodes were already launched, you should see flashing, non-red arrows in the top-left HUD to indicate Unity is communicating with ROS.

--------------------------------------------------------------------------------------------------------------------

### Executing Command Line Interface

This Section is to execute Jar file to access ROS environment through CLI.

 - Download JAR file.
 - Execute below command

```bash
java -jar Yatri-0.0.1-SNAPSHOT.jar
```

 - Execute below to download LTS Unity and visual studio required for Rover development.

```bash
 Download Unity
```
This results in: 
```bash
28852 [main] INFO com.Yatri.views.UnityView  - Starting downloading Unity
~$
```
 - Below are other CLI commands to be implemented

 ```bash
 - Environment Configuration
 - Simulation Setup
 - exit
 - help
```

-------------------------------------------------------------------------------------------------------------------------------------

# Accessing CLI for rover customization

## Building JAR file

- Clone GitHub repository using
```bash
git clone -b master git@github.com:ksharm53/SER515-Spring22-Team12.git
```
- Go to path 
```bash
SER515-Spring22-Team12\Yatri
```
- Build JAR file using command
```bash
mvn clean install
```
- This will create a JAR file with name Yatri-0.0.1-SNAPSHOT.jar in target folder.

## Executing Command Line Interface
- Go to path 
```bash
SER515-Spring22-Team12\Yatri\target
```
- Execute JAR using command
```bash
java -jar Yatri-0.0.1-SNAPSHOT.jar
```

## Downloading Customized Unity tool

- Execute below CLI command to initialize tool
```bash
init
```
- Enter <Yes> OR <Y> for input <Do you want to download pre confgured unity? [Y] Yes     [N] No:>
- Unity will get downloaded at below path with name UnityHubSetup.

```bash
SER515-Spring22-Team12\Yatri\target
```
- Execute .exe file and follow install steps.

## Downloading sample URDF file

- Execute below CLI command to initialize tool
```bash
init
```
- Enter <One Shape> for input <Select design of rover to be implemented:>
```bash
Select design of rover to be implemented:One Shape
```
- You can press tab button for auto suggestion.
- URDF file will get downloaded at  below path with name urdf.URDF

```bash
SER515-Spring22-Team12\Yatri\target
```
- Import URDF file in Unity.

## Setup customized Rover

- Enter preferred color for rover body input <Select color of rover body to be implemented:>
```bash
Select color of rover body to be implemented:blue
```
- You can press tab button for auto suggestions.

- Enter preferred size for rover's right wheel <Select size of the Right wheels for rover:>
```bash
Select size of the Right wheels for rover:smaller
```

- Enter preferred size for rover's left wheel <Select size of the Left wheels for rover:>
```bash
Select size of the Left wheels for rover:smaller
```
- press Enter
- URDF file will get downloaded at below path with name Yatri-URDF.urdf. 

```bash
SER515-Spring22-Team12\Yatri\target
```
- Import URDF file in Unity.

-------------------------------------------------------------------------------------------------------------------------------------
# # #GItHub Cleanup work:

GitHub Cleanup:

I was working on GitHub cleanup. There were some folders and files that needs to be cleaned for the proper functioning of the system.
-Initially sorted all the files according to the person who have added them. This helps in checking how  the file added by that team member will contribute in the functionality.
-After this, the files were selected which needs to be cleaned. There were some redundant files and some files which were not contributing significantly. So cleaned up those files and their corresponding folders.
-Some of the files were placed in different folders which needs to be placed at the right place so that their contribution can be obtained. These files were listed and placed in the perfect location.
-Asset is the folder which needed more cleaning. There were many separate folders in it like:
-CameraRover

-JumpMaterials

-Materials

-MaterialsMaze

-MaterialsRover

-Materials_integration_wheels

Now there were different types of files in these folders which were separated and combined into separate folders.

-All the scenes files were combined and put together in the scenes Folder.
-Some C# files, asset files and meta files were placed outside the folders, in common, as per the standard format.
-Whereas the folders of Prefabs, SampleScenes and Standard Assets were containing files which need not to be modified.
-Apart from this, Scenes folder, present outside along with other folders, was cleaned as it was having some scenes which were not contributing much.  

The other folders, including Design Docs, Library, Logs, Packages, ProjectSettings, Yatri and others were containing files which were sorted. Some adjustments were made and these folders were good.

-Some instance include the Design Docs folder which contains the pdf files which describes ROS simulation Wireframe Designs. These are the files contain generic data for representing the specific thing, hence they did not altered much.
-ProjectSettings and UserSettings folders contains the assets files which were sorted.
-Yatri is the  name of the project rover and the java source files were put in this folder.
-The Scripts folder contains the scripts that were used. It contains script especially for LIDAR sensors.
-The Library folder contains the files like PREFS, ASSET, JSON Source file, CATALOG file, some text files and some folders which were put altogether after cleaning.
-Also the Packages folder contains just the JSON source files. No other types were placec in this particular folder.

---------------------------------------------------------------------------------------------------------------------------------------------------------

Testing of UI:
The User Interfaces has been created for the project using Unity UIs. The UI has been created are:

-MainMenu

-ConfigMenu

-SimulateMenu

-InformationMenu

After creating this UIs, I worked on its testing to check all are working perfectly as expected.

-Primarily, MainMenu is the first UI with which user will interact first. It contains Environment Configuration, Simulation Setup, Information and Exit buttons. All the buttons were tested and working perfectly. They were navigating perfectly to the directed other UIs. The Exit button exits from the program. 

- When the Environment Configuration button is clicked, it navigates to ConfigMenu UI. This UI contains Manual Setup, Auto Setup and Back buttons. When back button is clicked, it navigates back to MainMenu. The button is working perfectly.

-Next, the Simulation Setup button in MainMenu when clicked, it navigates to the new UI of SimulateMenu. This function is working correctly with the expected output.

-In SimulateMenu, there are different options for the configuration of the project elements. Here, there are dropdown options for selecting maze size, selecting terrain and selecting type of wheels. The dropdown is showing the different options. Here, there are two other options- Back and Submit.

-After this, there is Information button in the MainMenu. When this button is clicked, it navigates to the Information UI. This UI and the function is properly functioning. 

-In the Information UI, we have given the information about the team and the team members. The names of all the team members are mentioned in this page. This UI also contains Back button to navigate back to the MainMenu UI.

-All the components in each UI such as texts and buttons, were placed in a component to keep all the elements in a combined form. This was noted and marked in the testing part. This feature helps to combine all elements of UI so that they can be accessed easily and combinedly.

-The goal regarding the UI, which was decided during planning were achieved and all the UIs are working as per expectation. (Noted during testing of UIs).

-------------------------------------------------------------------------------------------------------------------------------------

# Making Rover Movement Autonomous using SLAM and ROS2

## Environment setup

- Install the Unity Editor(same version we used)
- Set Up the ROS 2 Environment
- Build the Docker container(Link- https://github.com/Unity-Technologies/Robotics-Nav2-SLAM-Example/blob/main/ros2_docker/Dockerfile)

After environment is set up: 

- Scripts

Scripts are added according to the requirements.

AGVController
The Automated Guided Vehicle Controller. This Monobehaviour serves as a bridge between externally issued control signals and the ArticulationBody physics classes that we rely on to move our robots in physically accurate ways.

- Clock
In order to keep ROS 2 nodes and our time-dependent code in Unity synced, we define a Clock class that serves as an abstraction layer to ensure we use the same interface to access either Unity time or a ROS 2 time source. For the purposes of this example, we assume use_sim_time is true, and that Unity is providing the definitive clock.

- LaserScanSensor
A simple implementation of a "perfect" 2-dimensional LIDAR sensor which provides scans instantaneously and without any signal noise. We are working hard to implement accurate, high-fidelity sensor models to replace simple examples like this in the future.

- ROSClockPublisher
As the name implies, this publishes the output of our Clock class to the ROS /clock topic at fixed intervals. This allows other ROS 2 nodes to subscribe and stay in sync with the currently simulated time.

- ROSTransformTreePublisher
This class, along with TimeStamp, TransformExtensions, and TransformTreeNode, allows us to construct and publish tf2::TFMessages to ROS 2, representing the current state of the physical simulation in Unity.

###Prefabs
A few objects in our scene needed to be modified manually from what is produced by default by our tools. Prefabs are a useful way to modify and store specially configured objects for a particular scene.



###Marker
A simple sphere used to visualize LaserScan hits in the scene.

###ManualConfig
Often to support a specific use case in Unity, we need to modify an imported URDF to account for problematic mesh issues, like intersecting physics colliders, and to manually integrate components that we haven't implemented automated support for yet, like attaching a LaserScan sensor to the robot. If you double-click this prefab, Unity will display the Prefab Hierarchy in place of the usual Scene Hierarchy.

#The ROS 2 Workspace


The ROS 2 workspace is relatively simple for this Project, as we are, for the most part, just calling the default Nav2 and slam_toolbox launch files with small modifications to account for Unity being used as the simulator instead of Gazebo.

Launch file (unity_slam_example.py)
Simply includes the appropriate LaunchDescriptions from the nav2 example but also ensure use_sim_time is set to True across all Nodes

RViz config (nav2_unity.rviz)
Defines an RViz layout to support visualizing the topics that will be published from Unity.

Other project files
package.xml, setup.cfg, and setup.py are simply bog standard ROS 2 package files. We pulled these directly from examples in the ROS 2 tutorials and stripped away anything that was not necessary to support our example.

-------------------------------------------------------------------------------------------------------------------------------------

After setting up the environment 
Start the Unity simulation

With your scene open, simply press the Play button at the top.
animation of Play button being pressed and simulation starting

If the ROS2 nodes were already launched, you should see flashing, non-red arrows in the top-left HUD to indicate Unity is communicating with ROS.

Interacting with the projecct 
Once both the ROS2 nodes and Unity simulation are started and communicating correctly, you should see the occupancy map start to fill up in RViz.
animation of RViz rendering occupancy map and laser scans

The Rover is now localizing AND mapping, simultaneously! Now, to do navigation, click the 2D Goal Pose button, and left-click, drag, and release a location in RViz to send a commanded pose to the navigation stack.

it is using laserscan data published from unity to navigate the map

Adding Visualizations:
The visulaizations can be added from package manager to the unity and you can check them in window>>package manager

The Visualizations Package contains a DefaultVisualizationSuite prefab that provides visualizer components for many common ROS message types, organized in the hierarchy by package. These components control how messages are displayed in the Unity scene.

If Unity is still in Play mode, exit Play mode.

To add the default visualization suite, in the Project window, expand and select Packages/Robotics Visualization. Select the DefaultVisualizationSuite

Goal Pose Visualization
Topics will, by default, populate in the top-left HUD's Topics list. Let's begin with visualizing the Nav2 /goal_pose, a geometry_msgs/PoseStamped message.

If your previous navigation ROS nodes are still running, shut them down.run this command 

ros2 launch unity_slam_example unity_viz_example.py


In Unity, enter Play mode. Select the Topics tab in the HUD.

Click into the search bar, and begin typing /goal_pose. When it appears, select the /goal_pose topic name to toggle both the 2D and 3D options. Alternatively, you can select each individual toggle. 2D toggles a GUI window that displays a text-formatted version of the message. 3D toggles the 3D drawing.

If the HUD is not visible, ensure your connection throws no errors, your Nav2 ROS nodes are still running, and that Show HUD in the ROS Settings is on.

Topics that appear white are of a ROS message type that has a visualizer component in the scene. Topics that appear grey are of a ROS message type that does not currently have a visualizer component in the scene. Read more about this in the Usage Documentation.

You should now see a new window labeled with the /goal_pose topic in your Game view, saying "Waiting for message..."

You can click and drag the edges of the UI to adjust the size and placement of the topic's window.

Your UI layout and visualized topics are automatically saved to your local machine, which will be loaded next time you enter Play mode.

You can also specifically export and load layouts from your filesystem using the HUD's Layout tab.

You can now click the Topics tab again to close the list.



Open a new terminal in your ROS workspace and begin publishing goal poses, e.g.:

ros2 topic pub -1 /goal_pose geometry_msgs/PoseStamped "{header: {stamp: {sec: 0}, frame_id: 'map'}, pose: {position: {x: 0.0, y: -4.0, z: 0.0}, orientation: {w: 1.0}}}"
If you are using the suggested Docker + noVNC environment, you can copy and paste text into the environment by expanding (◀) the menu on the noVNC dock and selecting the clipboard icon. You can then add text into the box to add it to the Docker container's clipboard.



Map Visualization
Next, we'll visualize the map being made.

In Unity, select the Topics tab in the HUD to open the list again. Type /map in the search bar, then select the 3D toggle next to the /map topic name to toggle on the 3D drawing.
The map should now be appearing in the scene as the /map topic receives updates from ROS!

Add Global Costmap Visualization
You may also want to view the costmap at the same time. We know this is another occupancy grid message. Without specifying a topic, the visualizations for a ROS message type will follow the configuration for its Default Visualizer. In this scenario, that means that if you were to turn on the visualizations for /map and /global_costmap/costmap, it would be hard to distinguish between the two of them, as they'd both have the same exact customization from the Occupancy Grid Default Visualizer!

Exit Play mode.

In the scene Hierarchy, expand the DefaultVisualizationSuite. Expand the nav_msgs child object and select the OccupancyGrid object to open its Inspector.

Specify the Topic to be /map.

Although the default visualization suite is provided as a prefab, you are free to make changes to the suite for your own use.

Still on the OccupancyGrid object's Inspector window, click Add Component. Begin searching for Occupancy Grid Default Visualizer and add it to the object. You should now have two occupancy grid visualizers on this object!

The + icon on the newly added component indicates that it is added to a prefab, but the changes on it exist in this particular scene, and not the prefab file itself.

On the newly added component, specify this Topic as /global_costmap/costmap.

To set the default material to the new Occupancy Grid visualizer, assign the Material field to the OccupancyGrid material, found in Packages/Robotics Visualization/Runtime/Materials/OccupancyGrid.

You can find this file by searching in the Project window. Note that you will have to change the Search type from "In Assets" to "All". You can then select the OccupancyGrid material and drag and drop it into the Material field in your Occupancy Grid Default Visualizer's Inspector.

This material uses the provided OccupancyGrid shader, which has default behaviors for layering, transparency, color settings, and more, but you may also create and use your own material!



You may now want to differentiate between the two occupancy grid visualizers--in the Unoccupied Cell Color field of these two visualizers, feel free to start changing colors! We kept the /map as white, and changed the /global_costmap/costmap to be a light blue.



Once again, enter Play mode.

You may have to restart your ROS nodes before re-entering Play mode if you encounter unexpected issues. Check the Troubleshooting section below.

In the HUD's Topics window, toggle on the 3D for /global_costmap/costmap now.

You should now see the two maps updating in realtime! As you send goal poses to Turtlebot, the occupancy grid drawings should now update as expected.



Laser Scan Visualization
Finally, let's visit how the laser scan sensor is being visualized in the scene. Using the Visualizations Package, point cloud-type visualizations are highly customizable. This section will walk through customization options for a sensor_msgs/LaserScan visualization for your Nav2 project.

If you are still in Play mode, exit it.

In the scene Hierarchy, once again expand the DefaultVisualizationSuite. This time, expand the sensor_msgs object and select LaserScan to open its Inspector.

In the Topic field, enter /scan.

For messages with stamped headers, we need to specify how we want the visualizations to be drawn with respect to the TF tree. This is done via the TF Tracking Settings; click it to expand the options.

In this case, we want the laser scan to be drawn with respect to the most recent transform we have for its parent: Turtlebot's base_scan. To do so, change the Type to Track Latest. The TF Topic should be left as the default /tf.

