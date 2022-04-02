::setlocal EnableDelayedExpansion
setlocal ENABLEDELAYEDEXPANSION
set vidx=0
for /F "tokens=*" %%A in (Update_Configuration.txt) do (
    SET /A vidx=!vidx! + 1
    set var!vidx!=%%A
)
set var
echo "***********************************************************
echo %var1%
echo "Downloading Unity3D Assets"

set folderName_Unity3D_Asserts="Unity3d_Assets_1"
set url_of_git_repo_containing_assets_repo_URL="https://github.com/jjose14-Jacob-Jose/ser515-project-sprint4"
set url_of_git_repo_containing_assets_repo_name="ser515-project-sprint4"

set path_current_directory=%CD%

if exist %folderName_Unity3D_Asserts% (
    echo "Assets folder already exists"
    RMDIR /s /q %folderName_Unity3D_Asserts%
) else (
    echo "Creating Assets folder"
)
git.exe clone %url_of_git_repo_containing_assets_repo_URL%
echo "Finished downloading"
ren %url_of_git_repo_containing_assets_repo_name% %folderName_Unity3D_Asserts%
cd %folderName_Unity3D_Asserts%
echo %CD%
RMDIR /s /q ".git"

:: git.exe clone https://github.com/jjose14-Jacob-Jose/ser515-project-sprint4
:: ren ser515-project-sprint4 %folderName_Unity3D_Asserts%
:: cd %folderName_Unity3D_Asserts%
::
