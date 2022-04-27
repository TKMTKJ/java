from tkinter import *
import tkinter.messagebox

def clickLeft(event):
    tkinter.messagebox.showinfo("마우스","왼쪽 마우스가 클릭댐")
    
window=Tk()

window.bind("<Button-1>",clickLeft)

window.mainloop()