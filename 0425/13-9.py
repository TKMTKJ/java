from tkinter import *
from tkinter.filedialog import *

def func_open():
    filename = askopenfilename(parent=window, filetypes=(("GIF 파일","*.gif"),("모든파일","*.*")))
    photo=PhotoImage(file="../img/cat.gif")
    pLabel.configure(image=photo)
    pLabel.image=photo
    
def func_exit():
    window.quit()
    window.destroy()


window = Tk()
window.geometry("400x400")
window.title("메뉴만들기")

photo = PhotoImage()
pLabel = Label(window, image=photo)
pLabel.pack( expand=1, anchor=CENTER)

mainMenu = Menu(window)
window.config(menu = mainMenu)
fileMenu = Menu(mainMenu)
mainMenu.add_cascade(label = "파일", menu=fileMenu)
fileMenu.add_command(label = "열기", command=func_open)
fileMenu.add_separator()
fileMenu.add_command(label= "저장")
fileMenu.add_separator()
fileMenu.add_command(label="종료", command=func_exit)

window.mainloop()