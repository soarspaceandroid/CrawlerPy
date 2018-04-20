#!/usr/bin/python
# -*- coding: UTF-8 -*-

import os
import shutil

file = "app\\src\\main\\java\\com\\yonglibao\\android\\net\\Config.java"
#file = "Config.java"
env = ["api22", "api73", "api104"]
flag = "public static String test31"
replacePre = "api31"
outFile = "app\\build\\outputs\\apk\\debug\\app-debug.apk"
targetFile = "yonglibao_"


def log(content):
    print("------------>", content , "<------------")


def mymovefile(srcfile,dstfile):
    if not os.path.isfile(srcfile):
        log("%s not exist!"%(srcfile))
    else:
        fpath,fname=os.path.split(dstfile)    #分离文件名和路径
        if not os.path.exists(fpath):
            os.makedirs(fpath)                #创建路径
        shutil.move(srcfile,dstfile)          #移动文件
        log("move %s -> %s"%( srcfile,dstfile))



with open(file, "r", encoding="utf-8") as f:
    lines = f.readlines()

for envt in env:
    with open(file, "w", encoding="utf-8") as f_w:
        for line in lines:
            if flag in line:
                line = line.replace(replacePre, envt)
                log(line)
            f_w.write(line)
    commandRelease = os.popen('.\gradlew assembleDebug')
    log(commandRelease.read())
    mymovefile(outFile , targetFile+envt+".apk")



