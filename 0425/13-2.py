from tkinter import *
import tkinter.messagebox

def clicklmage (event):
    tkinter.messagebox.showinfo("마우스","토끼에서 마우스가 클릭댐")
    
window=Tk()
window.geometry("400x400")

photo=PhotoImage(file="../img/rabbit.gif")
label1=Label(window,image=photo)

label1.bind("<Button>",clicklmage)

label1.pack(expand=1,anchor=CENTER)
window.mainloop()