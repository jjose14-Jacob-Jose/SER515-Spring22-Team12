::setlocal EnableDelayedExpansion
echo "Uploading Assets to GitHub"

set url_of_git_repo_containing_assets_repo_URL="https://github.com/jjose14-Jacob-Jose/ser515-project-sprint4"

git.exe init
git.exe add *
git.exe commit -m "News file uploaded at %time% of %date%"
git.exe remote add origin %url_of_git_repo_containing_assets_repo_URL%
git.exe pull --set-upstream origin main
git.exe push origin HEAD:main --force
RMDIR /s /q ".git"

echo "Files uploaded to %url_of_git_repo_containing_assets_repo_URL%"

