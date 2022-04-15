Steps to convert Xacrofiles into URDF files.

Steps:
1. Remove any existing files and add all your xacro files into the folder 'urdf'.

2. Ensure that your xacro file containing the parent root is named 'origin.urdf'.

3. In CMD execute the following command:
	python xacro.py -o ./URDF_Generated.urdf urdf/<XACRO_ROOT_NAME>.xacro

	Example:
	python xacro.py -o ./URDF_Generated.urdf urdf/irb4600_60_205.xacro

4. 'URDF_Generated.urdf' would be the name of the final URDF File. 

Note:
If the program is not generating a URDF, then it means that the macro file has some problems. 

--------------------------------------------------------------------
