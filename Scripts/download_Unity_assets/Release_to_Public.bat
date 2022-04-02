@echo off
setlocal ENABLEDELAYEDEXPANSION
set vidx=0
for /F "tokens=2 delims==" %%A in (Release_to_Public-Config.txt) do (
    SET /A vidx=!vidx! + 1
    set var!vidx!=%%A
)
set var
set url_of_git_repo_containing_assets_repo_URL=%var1%
set folderContainingFilesToBeUploaded=%var2%
set existingMainBranchRepo="old_Main_Branch-%time% of %date%"

echo "Files are being uploaded to %url_of_git_repo_containing_assets_repo_URL%"

pushd .
mkdir %existingMainBranchRepo%
cd %existingMainBranchRepo%
git clone %url_of_git_repo_containing_assets_repo_URL%
git.exe rm -r *
git.exe add *
git.exe commit -m "Removing existing files at %time% of %date%"
git.exe push origin HEAD:main --force
RMDIR /s /q ".git"

popd
cd %folderContainingFilesToBeUploaded%
git.exe init
git.exe remote add origin %url_of_git_repo_containing_assets_repo_URL%
git.exe pull --set-upstream origin main
git.exe rm -r *
git.exe add *
git.exe commit -m "New files uploaded at %time% of %date%"
git.exe push origin HEAD:main --force
RMDIR /s /q ".git"

echo "Files uploaded to %url_of_git_repo_containing_assets_repo_URL%"

