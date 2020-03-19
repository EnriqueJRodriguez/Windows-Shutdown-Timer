@echo off
echo ======================================================
echo =                                                    =
echo =               Windows Shutdown Timer               =
echo =                by EnriqueJRodriguez                =
echo =                                                    =
echo ======================================================
:hours
set /P "hours=Hours until shutdown : "
echo %hours%|findstr /r "[^0-9]" && (
    echo enter a positive number
    goto :hours
)
:minutes
set /P "minutes=Minutes until shutdown : "
echo %minutes%|findstr /r "[^0-9]" && (
    echo enter a positive number
    goto :minutes
)
:seconds
set /P "seconds=Seconds until shutdown : "
echo %seconds%|findstr /r "[^0-9]" && (
    echo enter a positive number
    goto :seconds
)
set /A hourToSec = %hours% * 3600
set /A minToSec = %minutes% * 60
set /A totalSec = %hourToSec% + %minToSec% + %seconds%
shutdown -s -t %totalSec%
echo Shutdown timer created, press any key to exit.
pause>nul
exit