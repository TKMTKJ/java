from tkinter import *
import tkinter.messagebox

def func_exit():
    window.quit()
    window.destroy()
def func_open():
    tkinter.messagebox.showinfo("열기","열기메뉴를 선택함")
def func_save():
    tkinter.messagebox.showinfo("저장","저장메뉴를 선택함")

window = Tk()

mainMenu = Menu(window)
window.config(menu = mainMenu)

fileMenu = Menu(mainMenu)
mainMenu.add_cascade(label = "파일", menu=fileMenu)
fileMenu.add_command(label = "열기", command=func_open)
fileMenu.add_separator()
fileMenu.add_command(label= "저장", command=func_save)
fileMenu.add_separator()
fileMenu.add_command(label="종료", command=func_exit)

window.mainloop()