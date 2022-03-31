::setlocal EnableDelayedExpansion
@echo off
setlocal ENABLEDELAYEDEXPANSION
set vidx=0
for /F "tokens=2 delims==" %%A in (Release_to_Public-Config.txt) do (
    SET /A vidx=!vidx! + 1
    set var!vidx!=%%A
)
set var
echo "Value of var 1 is "
echo %var1%
echo "Uploading Assets to GitHub"

set url_of_git_repo_containing_assets_repo_URL=%var1%

git.exe init
git.exe add *
git.exe commit -m "News file uploaded at %time% of %date%"
git.exe remote add origin %url_of_git_repo_containing_assets_repo_URL%
git.exe pull --set-upstream origin main
git.exe push origin HEAD:main --force
RMDIR /s /q ".git"

echo "Files uploaded to %url_of_git_repo_containing_assets_repo_URL%"

