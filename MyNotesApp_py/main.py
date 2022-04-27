import tkinter as tk
from tkinter.filedialog import askopenfilename, asksaveasfilename


def open_file():
    """Opening file for editing"""

    filepath = askopenfilename(
        filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")]
    )

    if not filepath:
        return
    txt_edit.delete("1.0", tk.END)
    with open(filepath, "r") as input_file:
        text = input_file.read()
        txt_edit.insert(tk.END, text)
    window.title(f"Text Editor - {filepath}")


def save_file():
    """Saving file as a new file"""

    filepath = asksaveasfilename(
        defaultextension="txt",
        filetypes=[("Text files", "*.txt"), ("All files", "*.*")],
    )

    if not filepath:
        return
    with open(filepath, "w") as output_file:
        text = txt_edit.get("1.0", tk.END)
        output_file.write(text)
    window.title(f"Text Editor - {filepath}")


def open_note():

    global window, txt_edit, fr_buttons

    window = tk.Tk()
    window.title("MyNotes")
    window.rowconfigure(0, minsize=800, weight=1)
    window.columnconfigure(1, minsize=800, weight=1)

    txt_edit = tk.Text(window)
    fr_buttons = tk.Frame(window)

    btn_open = tk.Button(fr_buttons, text="Open", command=open_file)
    btn_save = tk.Button(fr_buttons, text="Save as...", command=save_file)

    btn_open.grid(row=0, column=0, sticky="ew", padx=5, pady=5)
    btn_save.grid(row=1, column=0, sticky="ew", padx=5)

    fr_buttons.grid(row=0, column=0, sticky="ns")
    txt_edit.grid(row=0, column=1, sticky="nsew")


def error_message(note_num=1):

    w = '600'
    h = '400'

    top = tk.Toplevel(window)
    top.title('Note{}.txt'.format(note_num))
    top.geometry('{}x{}'.format(w, h))

    frame = tk.Frame(top)

    label = tk.Label(frame, text="This is an error message")
    button = tk.Button(frame, text="Ok")

    frame.pack(expand=True)  # expand assigns additional space to the frame if the parent is expanded
    label.pack()
    button.pack()


def root_window():

    # Params:
    color = '#4a7a8c'
    w = '700'
    h = '500'

    # Creating new window:
    root = tk.Tk()
    root.title("MyNotes")
    root.config(bg=color)
    root.geometry('{}x{}'.format(w, h))

    # Welcome message:
    tk.Label(
        root,
        text="Welcome to MyNotes",
        bg=color,
        font=("Arial Bold", 14)
    ).pack(anchor='center', expand=True)

    # Button fir exiting the app:
    tk.Button(
        root,
        text='Exit',
        command=lambda: window.destroy(),
        font=("Arial Bold", 14)
    ).pack(side='left', anchor='e', expand=True)

    # Button for the new note creation:
    tk.Button(
        root,
        text='Create new note',
        command=lambda: open_note(),
        font=("Arial Bold", 14)
    ).pack(side='right', anchor='w', expand=True)

    root.mainloop()


if __name__ == '__main__':
    # Opening the root window == starting the application
    root_window()
