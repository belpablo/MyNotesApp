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


def start_application():

    global window
    window = tk.Tk()

    window.title("MyNotes")
    window.rowconfigure(0, minsize=800, weight=1)
    window.columnconfigure(1, minsize=800, weight=1)

    global txt_edit
    global fr_buttons
    txt_edit = tk.Text(window)
    fr_buttons = tk.Frame(window)

    btn_open = tk.Button(fr_buttons, text="Open", command=open_file)
    btn_save = tk.Button(fr_buttons, text="Save as...", command=save_file)

    btn_open.grid(row=0, column=0, sticky="ew", padx=5, pady=5)
    btn_save.grid(row=1, column=0, sticky="ew", padx=5)

    fr_buttons.grid(row=0, column=0, sticky="ns")
    txt_edit.grid(row=0, column=1, sticky="nsew")

    window.mainloop()


if __name__ == '__main__':
    start_application()