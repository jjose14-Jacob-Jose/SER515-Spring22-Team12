# SER515-Spring22-Team12 R -ver Input/ -utput Payl -ad

------------------------------------------------------------------------------------------------------------------------------------------------

R -ver General Activities & Payl -ads

•	User resp -nsibility t - st -p the r -ver  -nce:  st -p() c -mmand.
•	User resp -nsibility t - initiate  -r activate the r -ver: Init()  -r start() c -mmand.
•	User resp -nsibility t - m -ve R -ver f -rward: f -rward() c -mmand.
•	User resp -nsibility t - m -ve R -ver backwards: backward() c -mmand.
•	Halting r -ver f -r specific durati -n: sleep(<Interval>) c -mmand.
•	Driving t - a specific distance: drive(<Interval>, B - -lean)
•	Turning right right().
•	Turning right f -r specific durati -n right(<durati -n>).
•	Turning left left().
•	Turning right f -r specific durati -n left(<durati -n>).
•	Turning specific degree turn(<Degree>).
•	G -ing circular path  -rbit(<Degree>, <Radius>).
•	Setting specific speed speed(<Value>).


------------------------------------------------------------------------------------------------------------------------------------------------

Using ab -ve we can define  -ther pr -perties like 

•	All -wing R -ver t - g - square: g -Square()

f -r i in range(4):
  drive (length, true) # drive f -rward f -r length cm
  turn (90) # r -tate 90 degrees t - the right


------------------------------------------------------------------------------------------------------------------------------------------------

•	All -wing R -ver t - g - circle: g -Circle()

 -rbit(180, 50) # draw half a circle
turn(180) # r -tate the G -PiG -3 ar -und
 -rbit(-180, 50) # return  -n the initial path
turn(180) # and put it in the initial p -siti -n


------------------------------------------------------------------------------------------------------------------------------------------------


•	All -wing R -ver t - make 8 shapes: g -Eight()

 -rbit(-270, radius) # t - r -tate t - the left
drive(radius * 2) # m -ve f -rward
 -rbit(270, radius) # t - r -tate t - the right
gpg.drive_cm(radius * 2) # m -ve f -rward


------------------------------------------------------------------------------------------------------------------------------------------------

Sens -r Activities & Payl -ads

•	Send Temperature t - c -ntr -ller: send_temprature()

 -	Returns The temperature in Celsius degrees.
 -	Return type is fl -at.

------------------------------------------------------------------------------------------------------------------------------------------------

•	Send Humidity t - c -ntr -ller: send_humidity()
 -	Returns The humidity in percentage.
 -	Return type is fl -at.
 
------------------------------------------------------------------------------------------------------------------------------------------------

•	Get Safe Distance: get_safeDistance()
 -	Returns minimum distance fr -m target.
 -	Return type is int.

------------------------------------------------------------------------------------------------------------------------------------------------

•	Set Safe Distance: set_safeDistance()
 -	Input params are int.

------------------------------------------------------------------------------------------------------------------------------------------------

•	Capture LIDAR inf -: save_LIDARInf -()
 -	Input Params is LIDAR_ -BJECT
 -	Return is B - -lean if save is successful. 

------------------------------------------------------------------------------------------------------------------------------------------------

•	Validate If Maze traversed c -mpletely: IsFullyTraversed()
 -	Return is B - -lean if traverse is c -mplete  -r n -t.

------------------------------------------------------------------------------------------------------------------------------------------------

•	Validate r -ver health: IsHealthy()
 -	Return is B - -lean if r -ver is healthy.

------------------------------------------------------------------------------------------------------------------------------------------------

•	Validate r -ver health: send_Data()
 -	Return is data (sens -r and health) t - c -ntr -ller.
 -	This functi -n will als - be used in case r -ver is unhealthy.


------------------------------------------------------------------------------------------------------------------------------------------------
