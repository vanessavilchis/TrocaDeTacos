# 🚚💨 Welcome To **LA TROCA DE TACOS** 🌮

<img width="614" height="841" alt="Screenshot 2025-11-14 at 9 13 58 AM" src="https://github.com/user-attachments/assets/404a753b-f920-4bee-b05e-224329e388d6" />
<img width="549" height="916" alt="Screenshot 2025-11-14 at 9 15 18 AM" src="https://github.com/user-attachments/assets/b181e922-f7dc-442b-80bc-55bab45c2ca0" />
<img width="564" height="600" alt="Screenshot 2025-11-14 at 9 17 00 AM" src="https://github.com/user-attachments/assets/002af84a-8074-4ba4-8cb0-856468b2dae7" />







This is a **Java console-based Point of Sale (POS)** app built for a taco shop.  
Customers can create fully customized taco orders, pick drinks, add chips & salsa, and receive a digital receipt.

---

## Goals
- Replace handwritten orders
- Allow full customization of every item
- Generate digital receipts
- Keep the experience simple and user-friendly
- Demonstrate clean, professional Java design practices

---

## What It Can Do

### 🌮 Build-Your-Own Taco

**Choose:**

#### Sizes
- Single Taco — **$3.50**
- 3-Taco Plate — **$9.00**
- Burrito — **$8.50**

####  Tortillas
- Corn
- Flour
- Hard Shell
- Bowl

#### Premium Toppings (extra cost)
**Meats (6):**  
Carne Asada, Pollo, Carnitas, Al Pastor, Barbacoa, Pescado

**Cheeses (4):**  
Queso Fresco, Cheddar, Oaxaca, Cotija

**Extras:**  
Option to add extra meat or extra cheese

#### Free Toppings
Lettuce, Tomatoes, Onions, Cilantro, Jalapeños, Beans, Rice, Guac, Sour Cream

#### Free Salsas
Salsa Verde, Salsa Roja, Pico de Gallo, Chipotle, Habanero, Lime Crema

---

## Drinks
**Sizes:**
- Small — $2
- Medium — $2.50
- Large — $3

**Flavors:**  
8 total, including Agua Frescas: Horchata, Jamaica, Tamarindo

---

## Chips & Salsa
Fresh tortilla chips + choice of 6 salsas — **$1.50**

---

## Receipts
- Automatically generated with timestamps
- Shows detailed itemized breakdown
- Includes totals and extras
- Saved inside `/receipts` as:  
  **YYYYMMDD-HHMMSS.txt**

---

## Dynamic Pricing
The **Topping** class automatically adjusts topping prices based on taco size.
- Meats & cheeses have different costs for **Single**, **3-Taco Plate**, and **Burrito**
- Choosing “extra” adds the appropriate additional charge

---

## Using the App

1. Start the app — see the welcome screen
2. Create a new order
3. Add items:
    - Build tacos with toppings
    - Choose drink size & flavor
    - Add chips & salsa
4. Review your full order
5. Checkout to generate your digital receipt
6. Your receipt will appear inside the **/receipts/** folder

---
