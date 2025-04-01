# AI-Based Document Summarizer

## Overview

The **AI-Based Document Summarizer** is a Spring Boot-based application that allows users to upload documents (PDF, DOCX, TXT) and obtain a summarized version of the content using AI. The application uses advanced AI models like **T5** (from Hugging Face) to generate the summaries and provides a RESTful API for easy interaction.

This project utilizes **Deep Java Library (DJL)** to interact with Hugging Face models, **MongoDB** for storing documents and their summaries, and **Minio** as an object storage solution.

---

## Features

- **Document Upload**: Allows users to upload PDF, DOCX, or TXT files.
- **Text Summarization**: Uses a pre-trained AI model (T5) to summarize the content.
- **Storage**: Summaries and original documents are saved in **MongoDB** for later retrieval.
- **Object Storage**: **Minio** is used for storing files.
- **REST API**: Exposes an easy-to-use API for document submission and summarization.

---

## Technologies

- **Spring Boot**: Framework for building the RESTful API.
- **Deep Java Library (DJL)**: For running Hugging Face pre-trained models.
- **MongoDB**: Database for storing document and summary details.
- **Minio**: Object storage for file management.
- **Docker**: For containerizing the application with all dependencies.
- **Hugging Face**: For AI-powered text summarization using T5 models.

---

## Getting Started

### Prerequisites

Make sure you have the following tools installed:

- **Java 17 or later**
- **Maven**
- **Docker** (for running MongoDB and Minio)
- **Git**

---
