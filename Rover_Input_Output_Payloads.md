# # Rover Input/Output Payload

## General Activities & Payloads

 -	User responsibility to stop the rover once:  stop() command.
 -	User responsibility to initiate or activate the rover: Init() or start() command.
 -	User responsibility to move Rover forward: forward() command.
 -	User responsibility to move Rover backwards: backward() command.
 -	Halting rover for specific duration: sleep(<Interval>) command.
 -	Driving to a specific distance: drive(<Interval>, Boolean)
 -	Turning right right().
 -	Turning right for specific duration right(<duration>).
 -	Turning left left().
 -	Turning right for specific duration left(<duration>).
 -	Turning specific degree turn(<Degree>).
 -	Going circular path orbit(<Degree>, <Radius>).
 -	Setting specific speed speed(<Value>).

## Using above we can define other properties as below:

 -	Allowing Rover to go square: goSquare().

```java
for i in range(4):
  drive (length, true) # drive forward for length cm
  turn (90) # rotate 90 degrees to the right
```

 -	Allowing Rover to go circle: goCircle().

```java
orbit(180, 50) # draw half a circle
turn(180) # rotate 
orbit(-180, 50) # return on the initial path
turn(180) # and put it in the initial position
```

 -	Allowing Rover to make 8 shapes: goEight().

```java
orbit(-270, radius) # to rotate to the left
drive(radius * 2) # move forward
orbit(270, radius) # to rotate to the right
drive(radius * 2) # move forward
```


## Sensor Activities & Payloads


1.) Send Temperature to controller: send_temprature()

 -	Returns The temperature in Celsius degrees.
 -	Return type is float.

2.) Send Humidity to controller: send_humidity()

 -	Returns The humidity in percentage.
 -	Return type is float.

3.) Get Safe Distance: get_safeDistance()

 -	Returns minimum distance from target.
 -	Return type is int.


4.) Set Safe Distance: set_safeDistance()
 -	Input params are int.

5.) Capture LIDAR info: save_LIDARInfo()

 -	Input Params is LIDAR_oBJECT
 -	Return is Boolean if save is successful. 


6.) Validate If Maze traversed completely: IsFullyTraversed()
 -	Return is Boolean if traverse is complete or not.

7.) Validate rover health: IsHealthy()

 -	Return is Boolean if rover is healthy.


8.) Validate rover health: send_Data()
 -	Return is data (sensor and health) to controller.
 -	This function will also be used in case rover is unhealthy.
