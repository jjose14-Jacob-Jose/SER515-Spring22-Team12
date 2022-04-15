set currentDirectory=%cd%
set xacroDirectory=%currentDirectory%/Xacro_Files
set urdfDirectory=%currentDirectory%/
set xacroToUrdfPythonConverter=xacro.py

xcopy /s %currentDirectory%/xacro.py %xacroDirectory%

goto END
python xacro.py -o ./URDF_generated.urdf Xacro_Files/*.xacro

:END
echo %currentDirectory%/%xacroToUrdfPythonConverter%