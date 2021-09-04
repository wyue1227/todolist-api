import requests
import json

baseURL = "http://localhost:8080"
baseTodoURL = baseURL + "/todo"
todoListURL = baseURL + "/todolist"

headers = {"User-Agent": "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.6) ",
           "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
           "Accept-Language": "zh-CN",
           "Connection": "keep-alive",
           "Accept-Charset": "GB2312,utf-8;q=0.7,*;q=0.7",
           "token": "12345",
           "Content-Type": "application/json"}


def getTodoList(sectionID: int) -> dict:
    url = todoListURL + "/" + str(sectionID)
    print(url)
    res = requests.get(url=url, headers=headers)
    resStr = res.content.decode()
    # 将已编码的 JSON 字符串解码为 Python 对象
    jsonDict = json.loads(resStr)

    return jsonDict


def getTodoInfo(todoID: int) -> dict:
    url = baseTodoURL + "/" + str(todoID)
    res = requests.get(url=url, headers=headers)
    resStr = res.content.decode()
    # 将已编码的 JSON 字符串解码为 Python 对象
    jsonDict = json.loads(resStr)

    return jsonDict


def addTodo(content: str, remark: str, sectionID: int, planTime: str) -> dict:
    # AddTodoDto
    jsonStr = {
        "content": content,
        "remark": remark,
        "sectionID": sectionID,
        "planTime": planTime
    }
    url = baseTodoURL
    print(url)
    res = requests.post(url=url, headers=headers, json=jsonStr)
    resStr = res.content.decode()
    # 将已编码的 JSON 字符串解码为 Python 对象
    jsonDict = json.loads(resStr)

    return jsonDict


def deleteTodo(todoID: int) -> dict:
    url = baseTodoURL + "/" + str(todoID)
    print(url)
    res = requests.delete(url=url, headers=headers)
    resStr = res.content.decode()
    # 将已编码的 JSON 字符串解码为 Python 对象
    jsonDict = json.loads(resStr)

    return jsonDict


def updateTodoInfo(todoID: int, content: str, remark: str, sectionID: int, planTime: str) -> dict:
    url = baseTodoURL + "/" + str(todoID)
    # AddTodoDto
    jsonStr = {
        "content": content,
        "remark": remark,
        "sectionID": sectionID,
        "planTime": planTime
    }
    print(url)
    res = requests.put(url=url, headers=headers, json=jsonStr)
    resStr = res.content.decode()
    # 将已编码的 JSON 字符串解码为 Python 对象
    jsonDict = json.loads(resStr)

    return jsonDict


def updateTodoStatus(todoID: int, updateStatus: bool) -> dict:
    jsonStr = {
        "status": updateStatus
    }
    print(jsonStr)
    url = baseTodoURL + "/status" + "/" + str(todoID)
    print(url)
    res = requests.put(url=url, headers=headers, json=jsonStr)
    resStr = res.content.decode()
    # 将已编码的 JSON 字符串解码为 Python 对象
    jsonDict = json.loads(resStr)

    return jsonDict


# 格式化输出JSON
# js = json.dumps(result, sort_keys=True, indent=4, separators=(',', ':'))
# print(js)

# ------test start------
print(getTodoList(0))
print(getTodoInfo(1))
# print(addTodo("pycharm", "pycharm", 1, "2021-08-10 10:00:00"))
# print(deleteTodo(17))
# print(updateTodoInfo(16, "update content", "remark content", "1", planTime="2021-09-02 13:49:00"))
# print(updateTodoStatus(16, False))
