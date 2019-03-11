# Generated by Django 2.1.7 on 2019-03-05 03:04

import datetime
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('blog', '0003_fieldtest'),
    ]

    operations = [
        migrations.CreateModel(
            name='Person',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=255)),
                ('bio', models.CharField(blank=True, max_length=500)),
                ('bio2', models.CharField(max_length=500, null=True)),
                ('bio3', models.CharField(blank=True, max_length=500, null=True)),
                ('birth_date', models.DateField(default=datetime.date.today)),
            ],
        ),
    ]