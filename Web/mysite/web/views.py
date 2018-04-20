from django.shortcuts import render

# Create your views here.
from django.http import HttpResponse


def index(request):
    context = {"test":"我去回答是"}
    return render(request , "index.html" , context)