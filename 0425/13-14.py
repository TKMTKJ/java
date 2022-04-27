from tkinter import*
from tkinter.filedialog import *
from tkinter.simpledialog import *
from wand.image import *

def displayImage(img, width, height) :
    global window,canvas,paper,photo,photo2,oriX,oriY
    
    window.geometry(str(width)+"x"+str(height))
    if canvas !=None :
        canvas.destroy()
        
    canvas=Canvas(window, width=width, height=height)
    paper=PhotoImage(width=width, height=height)
    canvas.create_image( (width/2, height/2),
    image=paper, state="normal")
    
    blob = img.make_blib(format='RGB')
    for i in range(0, width):
        for k in range(0, width):
            r = blob[(i*3*width)+(k*3)+0]
            g = blob[(i*3*width)+(k*3)+1]
            b = blob[(i*3*width)+(k*3)+2]
            paper.put("#%02x%02x%02x" % (r,g,b),(k,i))
    canvas.pack()       
def func_open () :
    global window,canvas, paprer, photo,photo2,oriX,oriY
    readFp = askopenfilename(parent = window, filetypes=(("모든 그림 파일","*.jpg;*.jpeg;*.bmp;*.png;*.tif;*.gif"),("모든 파일","*.*")))
    photo = Image(filename=readFp)
    oriX=photo.width
    oriY=photo.height
    
    photo2=photo.clone()
    newX=photo2.width
    newY=photo2.height
    displayImage(photo2,newX,newY)

def func_save ():
    global window,canvas,paper,photo,photo2,oriX,oriY
    
    if photo2 == None :
        return
    saveFp = asksaveasfile(parent = window, mode ="w", defaultextension=".jpg", filetypes=(("JPG파 파일", "*.jpg;*.jpeg"), ("모든 파일","*.*")))
    savePhoto = photo2.convert("jpg")
    savePhoto.save(filename=svaeFp.neme)
def func_zoomin() :
    global window,canvas,paper,photo,photo2,oriX,oriY
    scale = askinteger("축소", "축소할 배수를 입력하세요",
    minvalue=2,maxvalue=4)
    photo2 = photo.clone()
    photo2.resize (int(oriX/scale) , int(oriY/scale))
    newX=photo2.width
    newY=photo2.height
    displayImage(photo2, newX, newY)

def func_exit():
    pass

def func_mirror1():
    pass
    