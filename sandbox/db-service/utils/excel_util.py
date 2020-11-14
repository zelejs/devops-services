import openpyxl


def write_excel(title, save_path, content):  # content List<List<String>> content 仅仅一个sheet
    wb = openpyxl.Workbook()
    sheet = wb.active
    sheet.title = title
    for i in range(0, len(content)):
        for j in range(0, len(content[i])):
            sheet.cell(row=i + 1, column=j + 1, value=str(content[i][j]))
    wb.save(save_path)
