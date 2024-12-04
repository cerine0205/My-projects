from random import randrange  
#-------------------------perent class---------------------------------
class Pet:
    sounds = ["Mrrp"]
    statments = [" "]
    boredom_threshold = 6
    hunger_threshold = 5
    boredom_decrement = 6
    hunger_decrement = 6
    hunger_limit = 14
    boredom_limit = 15
    
    def __init__(self,name):
        self.name = name
        self.hunger = 3
        self.boredom = 3
        self.sounds = self.sounds[:]

    def clock_tick(self):
        self.hunger += 1
        self.boredom += 1
        
    def mood(self):
        if self.boredom <= self.boredom_threshold and self.hunger <= self.hunger_threshold:
             return "happy"
        if  self.hunger > self.hunger_threshold and self.boredom <= self.hunger:
                return "hungry"
        if  self.boredom > self.boredom_threshold and self.boredom > self.hunger:
                return "bored"
        
    def shape(self):
         return " "
    
    def __str__(self) :
         return f"I am {self.name} and i feel {self.mood()}.{self.shape()}\n bored -> {self.boredom}\t hnuger -> {self.hunger}\n"
    
    def teach(self,word):
        self.sounds.append(word)
        self.reduce_boredom()
  
    def randomdWord(self):
         #genrate a random numbers
        indexForSounds = randrange(len(self.sounds))
        #extract the sound and statment form lists
        return self.sounds[indexForSounds]

    def hi(self):
        print(f"\n\t\t\t\t\t\t\t\t~{self.randomdWord()}~")
        
        self.reduce_boredom()

        
    def reduce_boredom(self):
        if self.boredom > 0: self.boredom -= self.boredom_decrement
        if self.boredom < 0: self.boredom = 0
        
    def feed(self):
         self.reduce_hunger()
        
    def reduce_hunger(self):
        if self.hunger > 0: self.hunger -= self.hunger_decrement
        if self.hunger < 0: self.hunger = 0
#end perent class

#---------------------------sup classes 1---------------------------------
#Cat
class Cat(Pet):
    sounds = ["Meow"]

    def shape(self):
        return ("""
           /\_/\  
          ( o.o ) 
           > ^ <
              """)

    def feed(self):
        indexForStatments = randrange(len(self.statments)) 
        statment = self.statments[indexForStatments]

        super().feed()
        print(f"\n\t\t\t\t\t\t{statment}\n\t\t\t\t\t\t\t\t~{super().randomdWord()}~")
        

   
#Dog
class Dog(Pet):
    sounds = ["Woof"]

    def shape(self):
        return ("""
          / \__
         (    @\___
          /         O
         /   (_____/
         /_____/   U
              """)

    def feed(self):
        indexForStatments = randrange(len(self.statments)) 
        statment = self.statments[indexForStatments]

        super().feed()
        print(f"\n\t\t\t\t\t\t{statment}\n\t\t\t\t\t\t\t\t~{super().randomdWord()}~")
    
#Bird
class Bird(Pet):
    sounds = ["Tweet tweet"]

    def shape(self):
        return ("""
           (o>
           (  \\_
            \_/  )
             _|_
              """)

    def feed(self):
        indexForStatments = randrange(len(self.statments)) 
        statment = self.statments[indexForStatments]

        super().feed()
        print(f"\n\t\t\t\t\t\t{statment}\n\t\t\t\t\t\t\t\t~{super().randomdWord()}~")

#----------------------------sup classes 2---------------------------
class Siamese(Cat):
    statments = ["The best food for a lively cat like me!","After this meal, I’ll be ready for a new chase!"]
   

class Persian(Cat):
    statments = ["I always deserve the finest dishes!","I need a nap after this delicious meal."]

class Labrador(Dog):
    statments =["This meal is delicious! I’m ready to play now!","Thank you for feeding me, now it’s time for a run!"]

class German(Dog):
    statments =["Great food! I’m ready for work now!","This is hero’s food, just like me!"]

class Parrot(Bird):
    statments =["This is great! I’ll tell everyone about my favorite food!","Did I tell you how delicious it is?! I can’t stop talking!"]

class Canary(Bird):
    statments =["The food is delicious! Now I’ll sing my sweetest tunes 🎶","Wow! This food gives me the energy to fly!"]

#end classes
#--------------------------METHODES--------------------------------------
#adapet a pet
def choice_a():
    while(True):#print the menu and take choice
                print(pet_type_menus()[0]) # pets menu
                typeChioce = type_chioce()

                #check pet Type (cat,dog,bird)
                if typeChioce == 'C':  #cat
                    catType = [Siamese,Persian]#sup classes
                    Enter_pet_in_dict(1,Cat,catType)#enter the pet in myPet dict
                    break

                elif typeChioce == "D": #Dog
                    dogType = [Labrador,German]#sup classes
                    Enter_pet_in_dict(2,Dog,dogType)#enter the pet in myPet dict
                    break

                elif typeChioce == "B": #Bird
                    birdType = [Parrot,Canary]#sup classes
                    Enter_pet_in_dict(3,Bird,birdType)#enter the pet in myPet dict
                    break

                else: #None of them
                    print("wrong selection try again")
       # break            
                    
#pet type menu
def pet_type_menus():
    menu = ["""
===============================
          pet type
===============================
Cat  --> Enter \033[34mC\033[0m 
Dog  --> Enter \033[34mD\033[0m
Bird --> Enter \033[34mB\033[0m
===============================
            """,
            """
=================================
           Cat type
=================================
Siamese  --> Enter \033[34m1\033[0m  | <Active>
Persian  --> Enter \033[34m2\033[0m  | <Sleepy>
=================================
            """,
            """
==============================================
                 Dog type            
==============================================
Labrador Retriver --> Enter \033[34m1\033[0m | <Friendly>
German Shepherd   --> Enter \033[34m2\033[0m |  <Strong>
==============================================
            """,
            """
================================
           Bird type
================================
Parrot --> Enter \033[34m1\033[0m  | <Chatty>
Canary --> Enter \033[34m2\033[0m  | <Singer>
================================
            """]
    return menu

#type chioce
def type_chioce():
    choice = input("Enter your choice: ").upper()
    return choice

#check pet type (1,2)
def Enter_pet_in_dict(index,pettype, petType2):
  
        print(pet_type_menus()[index]) #cat menu  
        while(True):  
            typeChioce = type_chioce()#(1,2)
            if typeChioce == '1':
                name = input("enter the pet name: ").lower()

                if name in myPets:
                    print("You already have a pet with that name")
                    continue
                myPets[name] = petType2[0](name)
                break

            elif typeChioce == '2':
                name = input("enter the pet name: ").lower()
                if name in myPets:
                    print("You already have a pet with that name")
                    continue
                myPets[name] = petType2[1](name)
                break

            else:
                print("wrong selection try again")
            
        
      
#teach a pet
def choice_t():
    if len(myPets) > 0:
        while(True):
            name = input("which pet do you want to teach? ").lower()

            #check if the pet is exis in my pets
            if name in myPets:
                pet = myPets[name] #the key is the name and the value is the opject of Pet
                word = input("what do you want to teach your pet? ")
                pet.teach(word)
                break
            else:
                print("yo do not have a pet with this name\n try again")
    else:
        print("you do not have any pet")
    
# pet greet you  
def choice_g():
    if len(myPets) > 0:
        while(True):
            name = input("which pet do you want to greet you? ").lower()

            #check if the pet is exis
            if name in myPets:
                pet = myPets[name]
                pet.hi()
                break
            else:
                print("yo do not have a pet with this name\n try again")
        
    else:
        print("you do not have any pet")

#print state
def My_Pets_Info():
     if len(myPets) != 0:
            print("\n\n========== My pets ==========" )#print the header
            for name in myPets:  # print info about pets
                    print( myPets[name]
                    ,"\n============================")

#feed pet
def choice_f():
    if len(myPets) > 0:
        while(True):
            name = input("which pet do you want to feed? ").lower()

            #check if the pet is exis
            if name in myPets:
                pet = myPets[name]
                pet.feed()
                break
            else:
                print("yo do not have a pet with this name \n try again")
    else:
        print("you do not have any pet")

#print sounds
def choice_s():
        if len(myPets) != 0:
            print("\n========== My pets Sounds ==========") #print the header
            for name in myPets:  # print info about pets
                print("\n"+name,"sounds -> ", myPets[name].sounds
                     ,"\n===================================")
        else:
             print("you do not have a pet yet")

#Game Instructions
def Game_Instructions():
    #coloring 
    reduce =  "\033[31m reduce them! \033[0m"
    feed  = "\033[34m feed \033[0m"
    teach = "\033[34m teach \033[0m"
    greet = "\033[34m greet \033[0m"
    hungerBoredom = "\033[32m hunger and boredom will set on 4 \033[0m"
    lessValue = "\033[32m less value \033[0m"
    level = "\033[31m if the hunger level = 15 or boredom level = 16 you will lose  \033[0m"
    
    print("\n\n\t\t=================================================================================================================================="
        +"\n\t\t||                                                 \033[1m Game Instructions \033[0m                                                          ||"
        +"\n\t\t=================================================================================================================================="
        +"\n\t\t||  in the start of the game the"+hungerBoredom+" and the <sound> will be diffrent debending on pet type       ||"
        +"\n\t\t||                                                                                                                              ||"
        +"\n\t\t||  over time the hunger and the boredom will increase you will have to"+reduce+"                                           ||"
        +"\n\t\t||  to decrease the:                                                                                                            ||"
        +"\n\t\t||     1) #> hunger <#   you will have to"+feed+"your pet                                 < hunger  - 6>                          ||"
        +"\n\t\t||     2) #> boredom <#  you can"+teach+"your pet or let it"+greet+"you                     < boredom - 6>                          ||"
        +"\n\t\t||                                                                                                                              ||"
        +"\n\t\t||  The"+lessValue+"for hunger or boredom is \033[32m 1 \033[0m                                                                                 ||"
        +"\n\t\t||                                                                                                                              ||"
        +"\n\t\t||                            "+level+"                                   ||" 
        +"\n\t\t==================================================================================================================================\n\n")

#lose
def lose():
    for pet in myPets:
        #check if the hunger or bored over the limit
        if(myPets[pet].hunger > myPets[pet].hunger_limit):
            print("\nyour "+pet+" starved to death. \n\t  \033[1;31mGame over\033[0m \n\n")
            exit()

        if(myPets[pet].boredom > myPets[pet].boredom_limit):
            print("\nyour "+pet+" got bored and ran away. \n\t   \033[1;31mGame over\033[0m \n\n")
            exit()
            

    
#end methodes
#-------------------------------------------------------------------------------
#main block
header = """\n\n    ===============================
        Welcome to the Pet Game"""

#creat a dict for all pet
myPets = {}
choice = ''


#print the Game Instructions
Game_Instructions()

while(True):
    answer = input("Enter Y to continue and E to exit: ").upper() #ask the user if he want to enter the game
    #check user choice
    if answer == 'Y':
        break
    elif answer == 'E':
        exit()
    else:
        print("wrong selection try again")

while(True):

    choice = input(header+"""
    ===============================
    enter \033[34mA\033[0m to Adopt pet
    enter \033[34mT\033[0m to teach pet                 
    Enter \033[34mG\033[0m to pet greet you   
    Enter \033[34mF\033[0m to feed pet                  
    Enter \033[34mS\033[0m to show all sounds
    Enter \033[34mQ\033[0m to Qiut game
    ===============================
    Enter your choice: """) .upper()

    print() # for new line
    
    if choice == 'A':
        choice_a()

    elif choice == 'T':
        choice_t()

    elif choice == 'G':
        choice_g()
   
    elif choice == 'F':
        choice_f()
    
    elif choice == 'S':
         choice_s()

    elif choice == 'Q':
         print("Thank you for your time :)")
         break
    
    else:
        print("invalid input try again")
        continue

    header = "" # to delet wolcome message
    for pet in myPets:
        myPets[pet].clock_tick() # increace the hunger and borad

    My_Pets_Info()# print pets state 

    # if the hunger or the bored is over the limit (game over)
    lose()

print() # for new line

#end main block
