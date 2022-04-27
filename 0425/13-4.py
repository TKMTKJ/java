from tkinter import *
import tkinter.messagebox

def keyEvent(event):
    tkinter.messagebox.showinfo("키보드 이벤트","눌린 키 : "
    +chr(event.keycode))
    
window = Tk()

window.bind("<Key>",keyEvent)

window.mainloop()